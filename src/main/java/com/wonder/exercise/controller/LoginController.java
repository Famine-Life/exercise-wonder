package com.wonder.exercise.controller;

import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.qd;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.CourseService;
import com.wonder.exercise.service.UserSelectCourseService;
import com.wonder.exercise.service.UserService;
import com.wonder.exercise.service.qdService;
import com.wonder.exercise.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    qdService qdService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserSelectCourseService userSelectCourseService;

    /**
     * 跳转到login 登录页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("userInfo");
        //判断是否登录
        if(user==null){
            user= new User();
            model.addAttribute("userInfo",user);
        }else{
            model.addAttribute("userInfo",user);
        }
        return "login";
    }


    /**
     * 处理登录操作,
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
//    @ResponseBody
//    @PostMapping("/login")
//    public Msg login(@RequestParam("username") String username
//            , @RequestParam("password") String password
//            , HttpServletRequest request
//            , Model model){
//
//        //判断账号是否存在
//        if(!userService.userNameIsExist(username)){
//            return  Msg.fail().add("result","账号不存在！");
//        }
//        User user = userService.selectByUsername(username);
//        //判断密码是否一致
//        if(!password.equals(user.getPassword())){
//            return Msg.fail().add("result","密码错误！");
//        }
//        //密码争取则存入session
//        request.getSession().setAttribute("userInfo",user);
//
//        return Msg.success().add("result","登录成功!");
//    }


    /**
     * 处理登录操作
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestParam("username") String username
            , @RequestParam("password") String password
            , HttpServletRequest request
            , Model model){
        User user = (User) request.getSession().getAttribute("userInfo");
        //判断是否登录
        if(user==null){
            user= new User();
            model.addAttribute("userInfo",user);
        }else{
            model.addAttribute("userInfo",user);
        }

        //判断账号是否存在
        if(!userService.userNameIsExist(username)){
            //return  Msg.fail().add("result","账号不存在！");

            model.addAttribute("loginError","error");
            model.addAttribute("errorMsg","账号不存在");
            return new ModelAndView("login");
        }
        user = userService.selectByUsername(username);
        //判断密码是否一致
        if(!password.equals(user.getPassword())){
            //return Msg.fail().add("result","密码错误！");
            model.addAttribute("loginError","error");
            model.addAttribute("errorMsg","密码错误");
            return new ModelAndView("login");
        }
        Integer role = user.getRole();
        String role_name = RoleEnum.ROLETYPE.values()[role].name();

        //密码正确则存入session
        request.getSession().setAttribute("userInfo",user);
        request.getSession().setAttribute("roleName",role_name);

        //签到部分数据
        List<Course> courseList = new ArrayList<>();
//        System.out.println("test:"+role_name);
        //如果是老师则从课程table里取
        if(role_name.equals("teacher")){
            courseList = courseService.selectByUser(user);
        }else{
            //否则都从选课表中取
            List<UserSelectCourse> userSelectCoursesList = userSelectCourseService.selectByUserId(user.getId());
            for (UserSelectCourse userSelectCourse: userSelectCoursesList) {
                Course course = courseService.selectByPrimaryKey(userSelectCourse.getCourseId());
                courseList.add(course);
            }
        }
       // model.addAttribute("nowDayCourseList",courseList);
        request.getSession().setAttribute("nowDayCourseList",courseList);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //判断当前账号，今日是否签到
        List<qd> qds = qdService.selectQdByUserId(user.getId());
        request.getSession().setAttribute("qd_text","签到");
        for (qd qd:qds) {
//            System.out.println(simpleDateFormat.format(qd.getQdTime())); // 2020-03-13
            //如果时间等于今天，那么今天已签到
            if(simpleDateFormat.format(qd.getQdTime()).equals(simpleDateFormat.format(System.currentTimeMillis()))) {
                request.getSession().setAttribute("qd_text", "已签到");
            }
        }

        return "index";
    }


    /**
     * 退出账号
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        //从session中删除保存的登录信息
        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("roleName");
        request.getSession().removeAttribute("nowDayCourseList");
        return "redirect:/login";
    }


}
