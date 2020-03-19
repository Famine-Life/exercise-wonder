package com.wonder.exercise.controller;


import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.service.CourseService;
import com.wonder.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Admin 后台管理
 */
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @GetMapping("admin")
    public String toAdmin(HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        String roleName =(String) request.getSession().getAttribute("roleName");
        if(!roleName.equals("admin")){
            return "redirect:/403";
        }

        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList",courseList);

        return "admins/admin";
    }




}
