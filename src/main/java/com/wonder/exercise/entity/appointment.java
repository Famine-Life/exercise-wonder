package com.wonder.exercise.entity;

import com.wonder.exercise.dao.UserMapper;
import com.wonder.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class appointment implements Serializable {

    private Integer id;

    private Integer requestUserId;

    private Integer requestedUserId;

    private Date appointmentTime;

    private Date requestTime;

    private Integer accept;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(Integer requestUserId) {
        this.requestUserId = requestUserId;
    }

    public Integer getRequestedUserId() {
        return requestedUserId;
    }

    public void setRequestedUserId(Integer requestedUserId) {
        this.requestedUserId = requestedUserId;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
    public String formateTime(Date date) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    @Override
    public String toString() {
        return "appointment{" +
                "id=" + id +
                ", requestUserId=" + requestUserId +
                ", requestedUserId=" + requestedUserId +
                ", appointmentTime=" + appointmentTime +
                ", requestTime=" + requestTime +
                ", accept=" + accept +
                ", delFlag=" + delFlag +
                '}';
    }
}