package com.wonder.exercise.service;

import com.wonder.exercise.entity.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);

    Boolean userNameIsExist(String username);

    User selectByUsername(String username);

    int insertSelective(User user);

    int  updateByPrimaryKey(User user);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int deleteByPrimaryKey(Integer id);

    List<User> selectAllTeacher();

}
