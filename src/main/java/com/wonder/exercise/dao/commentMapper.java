package com.wonder.exercise.dao;

import com.wonder.exercise.entity.comment;
import com.wonder.exercise.entity.commentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface commentMapper {
    long countByExample(commentExample example);

    int deleteByExample(commentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(comment record);

    int insertSelective(comment record);

    List<comment> selectByExample(commentExample example);

    comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") comment record, @Param("example") commentExample example);

    int updateByExample(@Param("record") comment record, @Param("example") commentExample example);

    int updateByPrimaryKeySelective(comment record);

    int updateByPrimaryKey(comment record);

    List<comment> selectByCourseId(Integer id);
}