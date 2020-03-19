package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.ProjectMapper;
import com.wonder.exercise.entity.Project;
import com.wonder.exercise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public Project selectByPrimaryKey(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> selectAll() {
        return projectMapper.selectAll();
    }
}
