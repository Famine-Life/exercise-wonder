package com.wonder.exercise.dao;

import com.wonder.exercise.entity.UserSelectCourse;
import com.wonder.exercise.entity.UserSelectCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserSelectCourseMapper {
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

    List<UserSelectCourse> selectByUserId(Integer id);

    List<UserSelectCourse> selectByCourseId(Integer id);
}