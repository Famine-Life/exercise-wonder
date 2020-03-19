package com.wonder.exercise.service;

import com.wonder.exercise.entity.Project;

import java.util.List;

public interface ProjectService {

    Project selectByPrimaryKey(Integer id);
    List<Project> selectAll();

}
