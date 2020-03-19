package com.wonder.exercise.controller;

import com.wonder.exercise.entity.Project;
import com.wonder.exercise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project 项目的处理器，主要用户管理员的增删操作。
 */
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectServise;

    @GetMapping("projects")
    public String getAllPro(){
        Integer id = 1;
        System.out.println(id);
        Project project = projectServise.selectByPrimaryKey(id);
        System.out.println("PorjectController 测试！");
        System.out.println(project.toString());
        return "success";
    }

}
