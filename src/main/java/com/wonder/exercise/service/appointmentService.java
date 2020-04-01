package com.wonder.exercise.service;

import com.wonder.exercise.entity.appointment;
import com.wonder.exercise.entity.appointmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface appointmentService {
    long countByExample(appointmentExample example);

    int deleteByExample(appointmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(appointment record);

    int insertSelective(appointment record);

    List<appointment> selectByExample(appointmentExample example);

    appointment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") appointment record, @Param("example") appointmentExample example);

    int updateByExample(@Param("record") appointment record, @Param("example") appointmentExample example);

    int updateByPrimaryKeySelective(appointment record);

    int updateByPrimaryKey(appointment record);

    List<appointment> selectByRequestUserId(Integer id);
    List<appointment> selectByRequestedUserId(Integer id);

    appointment isExist(appointment appointment);

}
