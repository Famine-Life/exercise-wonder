package com.wonder.exercise.dao;

import com.wonder.exercise.entity.qd;
import com.wonder.exercise.entity.qdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface qdMapper {
    long countByExample(qdExample example);

    int deleteByExample(qdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(qd record);

    int insertSelective(qd record);

    List<qd> selectByExample(qdExample example);

    qd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") qd record, @Param("example") qdExample example);

    int updateByExample(@Param("record") qd record, @Param("example") qdExample example);

    int updateByPrimaryKeySelective(qd record);

    int updateByPrimaryKey(qd record);

    List<qd> selectQdByUserId(Integer id);

}