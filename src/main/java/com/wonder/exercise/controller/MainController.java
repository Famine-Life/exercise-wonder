package com.wonder.exercise.controller;

import com.wonder.exercise.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 做一些简单的跳转处理
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("userInfo");
        //判断是否登录
        if(user==null){
            user= new User();
            model.addAttribute("userInfo",user);
        }else{
            model.addAttribute("userInfo",user);
        }
        return "index";
    }

    @GetMapping("/403")
    public String to403(){
        return "403";
    }
}
