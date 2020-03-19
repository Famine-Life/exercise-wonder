package com.wonder.exercise.dao;

import com.wonder.exercise.entity.Project;
import com.wonder.exercise.entity.UserCard;
import com.wonder.exercise.entity.UserCardExample;

import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCardMapper {
    long countByExample(UserCardExample example);

    int deleteByExample(UserCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCard record);

    int insertSelective(UserCard record);

    List<UserCard> selectByExample(UserCardExample example);

    UserCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCard record, @Param("example") UserCardExample example);

    int updateByExample(@Param("record") UserCard record, @Param("example") UserCardExample example);

    int updateByPrimaryKeySelective(UserCard record);

    int updateByPrimaryKey(UserCard record);


}