package com.wonder.exercise.service.serviceImpl;

import com.wonder.exercise.dao.walletMapper;
import com.wonder.exercise.entity.wallet;
import com.wonder.exercise.entity.walletExample;
import com.wonder.exercise.service.walletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements walletService {

    @Autowired
    walletMapper walletMapper;

    @Override
    public long countByExample(walletExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(walletExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(wallet record) {
        return 0;
    }

    @Override
    public int insertSelective(wallet record) {
        return walletMapper.insertSelective(record);
    }

    @Override
    public List<wallet> selectByExample(walletExample example) {
        return null;
    }

    @Override
    public wallet selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(wallet record, walletExample example) {
        return 0;
    }

    @Override
    public int updateByExample(wallet record, walletExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(wallet record) {
        return walletMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(wallet record) {
        return 0;
    }

    @Override
    public wallet selectByUserId(Integer id) {
        return walletMapper.selectByUserId(id);
    }
}
