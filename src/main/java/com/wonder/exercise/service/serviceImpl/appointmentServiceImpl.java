package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.appointmentMapper;
import com.wonder.exercise.entity.appointment;
import com.wonder.exercise.entity.appointmentExample;
import com.wonder.exercise.service.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentServiceImpl implements appointmentService {
    @Autowired
    com.wonder.exercise.dao.appointmentMapper appointmentMapper;

    @Override
    public long countByExample(appointmentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(appointmentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(appointment record) {
        return 0;
    }

    @Override
    public int insertSelective(appointment record) {
        return appointmentMapper.insertSelective(record);
    }

    @Override
    public List<appointment> selectByExample(appointmentExample example) {
        return null;
    }

    @Override
    public appointment selectByPrimaryKey(Integer id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(appointment record, appointmentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(appointment record, appointmentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(appointment record) {
        return appointmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(appointment record) {
        return 0;
    }

    @Override
    public List<appointment> selectByRequestUserId(Integer id) {
        return appointmentMapper.selectByRequestUserId(id);
    }

    @Override
    public List<appointment> selectByRequestedUserId(Integer id) {
        return appointmentMapper.selectByRequestedUserId(id);
    }

    @Override
    public appointment isExist(appointment appointment) {
        return appointmentMapper.isExist(appointment);
    }


}
