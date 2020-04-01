package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.UserSelectCourseMapper;
import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.UserSelectCourseExample;
import com.wonder.exercise.service.UserSelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserSelecyCourseServiceImpl implements UserSelectCourseService {

    @Autowired
    UserSelectCourseMapper userSelectCourseMapper;


    @Override
    public List<UserSelectCourse> selectByUserId(Integer id) {
        return userSelectCourseMapper.selectByUserId(id);
    }

    @Override
    public long countByExample(UserSelectCourseExample example) {
        return userSelectCourseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserSelectCourseExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserSelectCourse record) {
        return 0;
    }

    @Override
    public int insertSelective(UserSelectCourse record) {
        return userSelectCourseMapper.insertSelective(record);
    }

    @Override
    public List<UserSelectCourse> selectByExample(UserSelectCourseExample example) {
        return null;
    }

    @Override
    public UserSelectCourse selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(UserSelectCourse record, UserSelectCourseExample example) {
        return 0;
    }

    @Override
    public int updateByExample(UserSelectCourse record, UserSelectCourseExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(UserSelectCourse record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserSelectCourse record) {
        return 0;
    }

    @Override
    public List<UserSelectCourse> selectByCourseId(Integer id) {
        return userSelectCourseMapper.selectByCourseId(id);
    }


}
