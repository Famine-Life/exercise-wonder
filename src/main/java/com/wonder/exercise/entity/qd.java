package com.wonder.exercise.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class qd implements Serializable {
    private Integer id;

    private Integer userId;

    private Date qdTime;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getQdTime() {
        return qdTime;
    }

    public void setQdTime(Date qdTime) {
        this.qdTime = qdTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "qd{" +
                "id=" + id +
                ", userId=" + userId +
                ", qdTime=" + qdTime +
                ", delFlag=" + delFlag +
                '}';
    }
}