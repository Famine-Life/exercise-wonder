package com.wonder.exercise.controller;

import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.wallet;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.UserService;
import com.wonder.exercise.service.walletService;
import com.wonder.exercise.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * 处理账号注册
 */
@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    walletService walletService;

    @Autowired
    wallet wallet;

    /**
     * 跳转到register 注册页面
     * @return
     */
    @GetMapping("/register")
    public String toRegister(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("userInfo");
        //判断是否登录
        if(user==null){
            user= new User();
            model.addAttribute("userInfo",user);
        }else{
            model.addAttribute("userInfo",user);
        }
        return "register";
    }


//    @ResponseBody
//    @PostMapping("register")
//    public Msg register(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            @RequestParam("email") String email,
//            @RequestParam(value = "phone",required = false) String phone
//            ){
//        //检验账号，密码是否符合规范--
//
//        User user;
//        //判断账号是否存在
//        if(!userService.userNameIsExist(username)){
//            return  Msg.fail().add("result","账号不存在！");
//        }else{
//            user = new User();
//        }
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        user.setPhone(phone);
//        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        user.setRole(1);
//        user.setVipStatus(0);
//        //插入数据库
//        int i = userService.insertSelective(user);
//        if(i!=1){
//            return Msg.fail().add("result","数据库插入失败!");
//        }
//        return Msg.success();
//    }

    /**
     * 处理注册操作
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/register")
    public Object register(@RequestParam("username") String username
            , @RequestParam("password") String password
            , @RequestParam("name") String realName
            , @RequestParam("email") String email
            , @RequestParam("phone") String phone
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

        //空值判断, 有一项为空值则返回错误
        if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)||StringUtil.isEmpty(realName)||StringUtil.isEmpty(email)||StringUtil.isEmpty(phone)){
            model.addAttribute("loginError","error");
            model.addAttribute("errorMsg","请检查每一项信息都填写正确！");
            return new ModelAndView("register");
        }

        //判断账号是否存在
        if(userService.userNameIsExist(username)){
            model.addAttribute("loginError","error");
            model.addAttribute("errorMsg","账号已存在");
            return new ModelAndView("register");
        }else{
            user = new User();
        }

        user.setUsername(username);
        user.setPassword(password);
        user.setRealName(realName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setRole(1);
        user.setVipStatus(0);
        //插入数据库
        int i = userService.insertSelective(user);
        if(i!=1){
            model.addAttribute("loginError","error");
            model.addAttribute("errorMsg","注册失败，请重新尝试或者联系工作人员。");
            return new ModelAndView("register");
        }
        //初始化钱包
        wallet.setId(null);
        wallet.setUserId(user.getId());
        wallet.setMoney(null);
        walletService.insertSelective(wallet);

        return "redirect:/login";
    }

}
