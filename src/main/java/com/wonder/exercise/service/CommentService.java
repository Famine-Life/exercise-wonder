package com.wonder.exercise.service;

import com.wonder.exercise.entity.comment;
import com.wonder.exercise.entity.commentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
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
