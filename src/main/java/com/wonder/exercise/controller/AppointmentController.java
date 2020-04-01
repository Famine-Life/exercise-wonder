package com.wonder.exercise.controller;

import com.wonder.exercise.entity.User;
import com.wonder.exercise.entity.appointment;
import com.wonder.exercise.response.Msg;
import com.wonder.exercise.service.UserService;
import com.wonder.exercise.service.appointmentService;
import com.wonder.exercise.vo.appointmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

@Controller
public class AppointmentController {
    @Autowired
    UserService userService;
    @Autowired
    com.wonder.exercise.entity.appointment appointment;

    @Autowired
    com.wonder.exercise.service.appointmentService appointmentService;

    /**
     * 获取预约页面
     * @return
     */
    @GetMapping("appointment")
    public String toAppointment(HttpServletRequest request, Model model){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return "redirect:/login";
        }

//        Date datetime = new Timestamp(System.currentTimeMillis());
//        System.out.println("time:"+datetime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<appointmentVo> todayAppointmentList = new ArrayList<>();
        List<appointmentVo> acceptAppointmentList = new ArrayList<>();
        List<appointmentVo> notAcceptAppointmentList = new ArrayList<>();
        List<appointment> appointments;
        List<appointmentVo> appointmentVos=new ArrayList<>();
        //如果身份不是教师
        if(userInfo.getRole()!=2) {
            //当前用户的发起的所有预约
            appointments = appointmentService.selectByRequestUserId(userInfo.getId());
        }else{
            //别的用户对当前用户的预约
            appointments = appointmentService.selectByRequestedUserId(userInfo.getId());
        }
            for (appointment a:appointments) {
                System.out.println(a.toString());
                appointmentVo avo = new appointmentVo();
                avo.setId(a.getId());
                avo.setAccept(a.getAccept());
                avo.setAppointmentTime(a.getAppointmentTime());
                avo.setDelFlag(a.getDelFlag());
                avo.setRequestedUserId(a.getRequestedUserId());
                avo.setRequestedUsername(userService.selectByPrimaryKey(a.getRequestedUserId()).getRealName());
                avo.setRequestUserId(a.getRequestUserId());
                avo.setRequestUsername(userService.selectByPrimaryKey(a.getRequestUserId()).getRealName());
                appointmentVos.add(avo);
                //如果日期和今天相同
                if(simpleDateFormat.format(avo.getAppointmentTime()).equals(simpleDateFormat.format(System.currentTimeMillis()))){
                    //加入today list
                    todayAppointmentList.add(avo);
                }
                //已接受的预约
                if(avo.getAccept()==1){
                    acceptAppointmentList.add(avo);
                }
                //已接受的预约
                if(avo.getAccept()!=1){
                    notAcceptAppointmentList.add(avo);
                }
            }
            model.addAttribute("allAppointments",appointmentVos);
            model.addAttribute("acceptAppointmentList",acceptAppointmentList);
            model.addAttribute("todayAppointmentList",todayAppointmentList);
            model.addAttribute("notAcceptAppointmentList",notAcceptAppointmentList);



        return "user/appointment";
    }

    /**
     * 预约方法，传递一个教练的id参数
     * @return
     */
    @ResponseBody
    @PostMapping("appointment")
    public Msg appointment(@RequestBody Map<String, Object> paramsMap, HttpServletRequest request) throws ParseException {
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return Msg.fail().add("result","请先登录!");
        }
        if(userInfo.getRole()==2){
            return Msg.fail().add("result","请使用学员账号!");
        }


        String id = paramsMap.get("id").toString();
        String time = paramsMap.get("time").toString();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
        Date datetime = sdf.parse(time);
        System.out.println(id+",时间:"+time);

        //判断这个时间是否已经有过相同的教练的预约
        //当前登录用户的预约表list
        List<appointment> appointments = appointmentService.selectByRequestUserId(userInfo.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (appointment appointment: appointments) {
            //如果列表里出现时间和提交的时间相同
            if(simpleDateFormat.format(appointment.getAppointmentTime()).equals(simpleDateFormat.format(datetime))){
                if(appointment.getRequestedUserId().equals(Integer.valueOf(id))){
                    return Msg.fail().add("result","抱歉，您在这个日期已与这位教练预约了，或者已发送过了预约请求!");
                }
            }

        }

        appointment.setId(null);
        appointment.setRequestUserId(userInfo.getId());
        appointment.setRequestedUserId(Integer.valueOf(id));
        appointment.setAppointmentTime(datetime);
        appointment.setRequestTime(new Timestamp(System.currentTimeMillis()));
        appointment.setAccept(0);
        appointment.setDelFlag(0);
        int i = appointmentService.insertSelective(appointment);
        if (i != 1) {
            return Msg.fail().add("result","预约失败!请重新尝试");
        }

        return Msg.success();
    }

    /**
     * 接受预约
     * @return
     */
    @ResponseBody
    @PostMapping("/acceptApointment")
    public Msg acceptApointment(@RequestParam("id") Integer id,HttpServletRequest request){
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if(userInfo==null){
            return Msg.fail().add("result","请先登录!");
        }
        if(userInfo.getRole()!=2){
            return Msg.fail().add("result","权限不足!");
        }

        appointment appointment = appointmentService.selectByPrimaryKey(id);
        appointment.setAccept(1);
        int i = appointmentService.updateByPrimaryKeySelective(appointment);
        if(i!=1){
            return Msg.fail().add("result","接受预约失败，请重新尝试!");
        }

        return Msg.success();
    }

}
