package com.wonder.exercise.controller;

import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.UserSelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class UserSelectCourseController {

    @Autowired
    UserSelectCourseService userSelectCourseService;

    /**
     * 添加选课
     * @return
     */
    @ResponseBody
    @PostMapping("addSelectCourse")
    public Msg insertUserSelectCourse(@RequestParam("id") Integer course_id, HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return Msg.fail().add("result","未登录!请先登录您的账号!");
        }

        //判断该账号是否已经选了该课程
        List<UserSelectCourse> userSelectCourses = userSelectCourseService.selectByUserId(userInfo.getId());
        for (UserSelectCourse userSelectCourse:userSelectCourses) {
            //如果当前账号在选课表中已有相同的课程id，那么为已选
            if(userSelectCourse.getCourseId().equals(course_id)){
                return Msg.fail().add("result","当前课程您已经拥有！请选择其他课程!");
            }
        }

        UserSelectCourse userSelectCourse = new UserSelectCourse();
        userSelectCourse.setUserId(userInfo.getId());
        userSelectCourse.setCourseId(course_id);
        userSelectCourse.setDelFlag(0);
        userSelectCourse.setCreateTime(new Timestamp(System.currentTimeMillis()));

        //插入选课表
        int i = userSelectCourseService.insertSelective(userSelectCourse);
        if(i!=1){
            return Msg.fail().add("result","选课失败，请重新尝试。");
        }

        return Msg.success();
    }

}
