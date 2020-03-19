package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.qdMapper;
import com.wonder.exercise.entity.qd;
import com.wonder.exercise.entity.qdExample;
import com.wonder.exercise.service.qdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class qdServiceImpl implements qdService {

    @Autowired
    qdMapper qdMapper;

    @Override
    public long countByExample(qdExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(qdExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(qd record) {
        return 0;
    }

    @Override
    public int insertSelective(qd record) {
        return qdMapper.insertSelective(record);
    }

    @Override
    public List<qd> selectByExample(qdExample example) {
        return null;
    }

    @Override
    public qd selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(qd record, qdExample example) {
        return 0;
    }

    @Override
    public int updateByExample(qd record, qdExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(qd record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(qd record) {
        return 0;
    }

    @Override
    public List<qd> selectQdByUserId(Integer id) {
        return qdMapper.selectQdByUserId(id);
    }
}
