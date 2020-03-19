package com.wonder.exercise.service;

import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.UserSelectCourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSelectCourseService {

    List<UserSelectCourse> selectByUserId(Integer id);

    long countByExample(UserSelectCourseExample example);

    int deleteByExample(UserSelectCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSelectCourse record);

    int insertSelective(UserSelectCourse record);

    List<UserSelectCourse> selectByExample(UserSelectCourseExample example);

    UserSelectCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSelectCourse record, @Param("example") UserSelectCourseExample example);

    int updateByExample(@Param("record") UserSelectCourse record, @Param("example") UserSelectCourseExample example);

    int updateByPrimaryKeySelective(UserSelectCourse record);

    int updateByPrimaryKey(UserSelectCourse record);

    List<UserSelectCourse> selectByCourseId(Integer id);
}
