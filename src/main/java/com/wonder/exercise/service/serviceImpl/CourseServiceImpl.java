package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.CourseMapper;
import com.wonder.exercise.entity.Course;
import com.wonder.exercise.entity.CourseExample;
import com.wonder.exercise.entity.User;
import com.wonder.exercise.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> selectByExample(CourseExample courseExample) {
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return null;
    }

    @Override
    public List<Course> selectByUser(User user) {
        return courseMapper.selectByUser(user);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }
}
