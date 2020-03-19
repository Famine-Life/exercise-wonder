package com.wonder.exercise.dao;

import com.wonder.exercise.entity.Place;
import com.wonder.exercise.entity.PlaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaceMapper {
    long countByExample(PlaceExample example);

    int deleteByExample(PlaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Place record);

    int insertSelective(Place record);

    List<Place> selectByExample(PlaceExample example);

    Place selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByExample(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
}