package com.wonder.exercise.controller;

import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.CourseService;
import com.wonder.exercise.service.UserService;
import com.wonder.exercise.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class userController {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;

    /**
     * 获取当前登录用户信息, 返回页面
     * @return
     */
    @GetMapping("getLoginUserInfo")
    public String getLoginUserInfo(HttpServletRequest request, Model model){
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        model.addAttribute("user",userInfo);
        return "user/userInfo";
    }


    @GetMapping("user/edit/{id}")
    public ModelAndView toEditUser(@PathVariable("id") Integer id, Model model){
        User user = userService.selectByPrimaryKey(id);
        return new ModelAndView("user/edit", "user", user);
    }

    /**
     * 管理员修改用户信息
     * @return
     */
    @ResponseBody
    @PostMapping("user/edit")
    public String editUser(User user, HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        String roleName =(String) request.getSession().getAttribute("roleName");
        if(!roleName.equals("admin")){
            return "redirect:/403";
        }
        System.out.println("user/edit:"+user.toString());
        int i = userService.updateByPrimaryKeySelective(user);
        if(i!=1){
            return "更新失败";
        }
        return "更新成功";
    }

    /**
     * 当前用户修改自己的信息
     * @param username
     * @param password
     * @param realName
     * @param email
     * @param phone
     * @param request
     * @param model
     * @return
     */
    @PostMapping("changeMyInfo")
    public String updateUser(@RequestParam("username") String username
            , @RequestParam("password") String password
            , @RequestParam("name") String realName
            , @RequestParam("email") String email
            , @RequestParam("phone") String phone
            , HttpServletRequest request
            , Model model){
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }
        if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)||StringUtil.isEmpty(realName)||StringUtil.isEmpty(email)||StringUtil.isEmpty(phone)){
            return "redirect:/getLoginUserInfo";
        }else{
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            userInfo.setRealName(realName);
            userInfo.setEmail(email);
            userInfo.setPhone(phone);
            userInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            int i = userService.updateByPrimaryKey(userInfo);
            if(i==1){
                request.getSession().setAttribute("userInfo",userInfo);
            }
        }
        return "redirect:/getLoginUserInfo";
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping(value = "user/{id}")
    public Msg delete(@PathVariable("id") Integer id, Model model) {
        try {
            userService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            return Msg.fail().add("result","删除失败!");
        }
        return  Msg.success().add("result","删除成功!");
    }

    /**
     * 返回所有teacher用户
     */
    @GetMapping("teachers")
    public String teacher(HttpServletRequest request, Model model){
        List<User> userList = userService.selectAllTeacher();
        model.addAttribute("teacherList",userList);
        return "user/teachers";
    }

    /**
     * 返回单个teacher用户详情
     */
    @GetMapping(value = "/teacher/{id}/detail")
    public String teacherDetail(@PathVariable("id") Integer id, HttpServletRequest request, Model model){
        System.out.println("teacher:"+id);
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("teacher",user);
        List<Course> courses = courseService.selectByUser(user);
        model.addAttribute("courseList",courses);
        return "user/teacherDetail";
    }

}
