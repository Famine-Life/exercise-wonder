package com.wonder.exercise.service;

import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.CourseExample;
import com.wonder.exercise.entity.User;

import java.util.List;

public interface CourseService {

    List<Course> selectByExample(CourseExample courseExample);

    List<Course> selectByUser(User user);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();

    int insertSelective(Course record);

    int updateByPrimaryKeySelective(Course record);

    int deleteByPrimaryKey(Integer id);

}
