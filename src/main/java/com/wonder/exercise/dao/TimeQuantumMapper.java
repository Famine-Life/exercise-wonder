package com.wonder.exercise.dao;

import com.wonder.exercise.entity.TimeQuantum;
import com.wonder.exercise.entity.TimeQuantumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeQuantumMapper {
    long countByExample(TimeQuantumExample example);

    int deleteByExample(TimeQuantumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TimeQuantum record);

    int insertSelective(TimeQuantum record);

    List<TimeQuantum> selectByExample(TimeQuantumExample example);

    TimeQuantum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TimeQuantum record, @Param("example") TimeQuantumExample example);

    int updateByExample(@Param("record") TimeQuantum record, @Param("example") TimeQuantumExample example);

    int updateByPrimaryKeySelective(TimeQuantum record);

    int updateByPrimaryKey(TimeQuantum record);
}