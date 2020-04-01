package com.wonder.exercise.controller;

import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.wallet;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.CourseService;
import com.wonder.exercise.service.UserSelectCourseService;
import com.wonder.exercise.service.walletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * 钱包处理器
 */
@Controller
public class WalletController {

    @Autowired
    UserSelectCourseService userSelectCourseService;

    @Autowired
    walletService walletService;

    @Autowired
    wallet wallet;

    @Autowired
    CourseService courseService;

    /**
     * 返回钱包页面
     * @param request
     * @param model
     * @return
     */
    @GetMapping("wallet")
    public String getUserWallet(HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }

        wallet wallet = walletService.selectByUserId(userInfo.getId());
        model.addAttribute("wallet",wallet);

        return "wallet/wallet";
    }

    /**
     * 充值
     * @param request
     * @param model
     * @param money
     * @return
     */
    @ResponseBody
    @PostMapping("pushmoney")
    public Msg pushMoney(HttpServletRequest request, Model model, @RequestParam("money") String money){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return Msg.fail().add("result","请先登录!");
        }
        wallet wallet = walletService.selectByUserId(userInfo.getId());
        BigDecimal old_money = wallet.getMoney();
        BigDecimal new_money = old_money.add(new BigDecimal(money));
        wallet.setMoney(new_money);
        int i = walletService.updateByPrimaryKeySelective(wallet);
        if(i!=1){
            return Msg.fail().add("result","充值失败，请重新尝试!");
        }
        return Msg.success();
    }

    /**
     * 扣费
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @PostMapping("popmoney")
    public Msg popMoney(HttpServletRequest request, Model model, @RequestParam("id") Integer course_id){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return Msg.fail().add("result","请先登录!");
        }
        //判断该账号是否已经选了该课程
        List<UserSelectCourse> userSelectCourses = userSelectCourseService.selectByUserId(userInfo.getId());
        for (UserSelectCourse userSelectCourse:userSelectCourses) {
            //如果当前账号在选课表中已有相同的课程id，那么为已选
            if(userSelectCourse.getCourseId().equals(course_id)){
                return Msg.fail().add("result","当前课程您已经拥有！请选择其他课程!");
            }
        }

        //获取钱包信息
        wallet wallet = walletService.selectByUserId(userInfo.getId());
        BigDecimal user_money = wallet.getMoney();

        Course course = courseService.selectByPrimaryKey(course_id);
        BigDecimal money = course.getMoney();
        if(user_money.intValue()<money.intValue()){
            return Msg.fail().add("result","余额不足!");
        }
        //相减
        BigDecimal new_money = user_money.subtract(money);
        wallet.setMoney(new_money);
        int i = walletService.updateByPrimaryKeySelective(wallet);
        if(i!=1){
            return Msg.fail().add("result","扣费失败，请重新尝试!");
        }
        return Msg.success().add("result","付款成功!");
    }



}
