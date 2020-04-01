package com.wonder.exercise.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class appointmentVo {

    private Integer id;

    private Integer requestUserId;

    private String requestUsername;

    public String getRequestUsername() {
        return requestUsername;
    }

    public void setRequestUsername(String requestUsername) {
        this.requestUsername = requestUsername;
    }

    public String getRequestedUsername() {
        return requestedUsername;
    }

    public void setRequestedUsername(String requestedUsername) {
        this.requestedUsername = requestedUsername;
    }

    private Integer requestedUserId;

    private String requestedUsername;

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
        return "apointmentVo{" +
                "id=" + id +
                ", requestUserId=" + requestUserId +
                ", requestUsername='" + requestUsername + '\'' +
                ", requestedUserId=" + requestedUserId +
                ", requestedUsername='" + requestedUsername + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", requestTime=" + requestTime +
                ", accept=" + accept +
                ", delFlag=" + delFlag +
                '}';
    }
}
