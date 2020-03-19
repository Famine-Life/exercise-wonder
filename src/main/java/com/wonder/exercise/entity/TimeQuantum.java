package com.wonder.exercise.entity;

import java.io.Serializable;

public class TimeQuantum implements Serializable {
    private Integer id;

    private String text;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}