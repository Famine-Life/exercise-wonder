package com.wonder.exercise.controller;

import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.qd;
import com.wonder.exercise.service.CourseService;
import com.wonder.exercise.service.UserSelectCourseService;
import com.wonder.exercise.service.UserService;
import com.wonder.exercise.service.qdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 签到
 */
@Controller
public class qdController {

    @Autowired
    qdService qdService;

    @Autowired
    private qd qd;

    @Autowired
    CourseService courseService;

    @Autowired
    UserSelectCourseService userSelectCourseService;

    @Autowired
    UserService userService;

    /**
     * 处理签到请求
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("qd")
    public String qd(HttpServletRequest request, Model model){
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //判断当前账号，今日是否签到
        List<qd> qds = qdService.selectQdByUserId(userInfo.getId());
        for(qd qd:qds){
            //如果时间等于今天，那么今天已签到
            if(simpleDateFormat.format(qd.getQdTime()).equals(simpleDateFormat.format(System.currentTimeMillis()))) {
                return "isQded";
            }
        }

        qd.setId(null);
        qd.setUserId(userInfo.getId());
        qd.setQdTime(new Timestamp(System.currentTimeMillis()));
        qd.setDelFlag(0);
        int i = qdService.insertSelective(qd);
        if(i!=1){
            return "insert datasourse error";
        }
        request.getSession().setAttribute("qd_text", "已签到");

        return "success";
    }


    /**
     * 获取考勤信息，也就是该老师的课，谁没签到
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getAttendance")
    public String getAttendance(HttpServletRequest request, Model model){
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        String roleName = (String) request.getSession().getAttribute("roleName");
        //如果当前身份不是是老师，或者管理员
        if(!roleName.equals("teacher")){
            return "redirect:/403"; //权限不足
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<User> userList = new ArrayList<>();
        List<User> qd_userList = new ArrayList<>();
        //获取老师开设的课程列表
        List<Course> courses = courseService.selectByUser(userInfo);
        if(courses.size()==0){
            return "0";
        }else{
            for (Course c : courses) {
                //获取选课列表的数据
                List<UserSelectCourse> userSelectCourses = userSelectCourseService.selectByCourseId(c.getId());
                for (UserSelectCourse userSelectCourse:userSelectCourses) {
                    User user = userService.selectByPrimaryKey(userSelectCourse.getUserId());
                    System.out.println(userSelectCourse.getUserId());
                    System.out.println("选课："+user.toString());
                    userList.add(user);
                    //当前学生的签到信息
                    List<qd> qds  = qdService.selectQdByUserId(user.getId());
                    for (qd qd :qds) {
                        //如果时间等于今天，那么今天已签到
                        if(simpleDateFormat.format(qd.getQdTime()).equals(simpleDateFormat.format(System.currentTimeMillis()))) {
                            System.out.println("签到user:"+user.toString());
                            //存入签到列表
                            qd_userList.add(user);
                        }
                    }
                }
            }


            //返回选了当前老师的课的所有学生列表
//            HashSet<User> users = new HashSet<>();
//            users.addAll(userList);     //用set 去重
            model.addAttribute("userList",userList);    //所有选课的用户
            model.addAttribute("qd_userList",qd_userList);     //已签到的用户

            List<User> not_qd_userList = new ArrayList<>();
            not_qd_userList.addAll(userList);
            //未签到的not_qd_userList
            not_qd_userList.removeAll(qd_userList);
            model.addAttribute("not_qd_userList",not_qd_userList);      //未签到的用户

            //测试
//            for (User u :
//                    userList) {
//                System.out.print("userlist test:");
//                System.out.println(u.toString());
//            }

        }

        return "attendance";
    }

}
