package com.wonder.exercise.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Component
public class wallet implements Serializable {
    private Integer id;

    private Integer userId;

    private BigDecimal money;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "wallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", money=" + money +
                '}';
    }
}