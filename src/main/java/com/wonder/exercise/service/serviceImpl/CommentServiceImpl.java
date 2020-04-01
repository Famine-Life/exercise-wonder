package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.commentMapper;
import com.wonder.exercise.entity.comment;
import com.wonder.exercise.entity.commentExample;
import com.wonder.exercise.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    commentMapper commentMapper;

    @Override
    public long countByExample(commentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(commentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(comment record) {
        return 0;
    }

    @Override
    public int insertSelective(comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public List<comment> selectByExample(commentExample example) {
        return null;
    }

    @Override
    public comment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(comment record, commentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(comment record, commentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(comment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(comment record) {
        return 0;
    }

    @Override
    public List<comment> selectByCourseId(Integer id) {
        return commentMapper.selectByCourseId(id);
    }
}
