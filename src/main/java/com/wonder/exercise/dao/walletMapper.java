package com.wonder.exercise.dao;

import com.wonder.exercise.entity.wallet;
import com.wonder.exercise.entity.walletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface walletMapper {
    long countByExample(walletExample example);

    int deleteByExample(walletExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wallet record);

    int insertSelective(wallet record);

    List<wallet> selectByExample(walletExample example);

    wallet selectByPrimaryKey(Integer id);

    wallet selectByUserId(Integer id);

    int updateByExampleSelective(@Param("record") wallet record, @Param("example") walletExample example);

    int updateByExample(@Param("record") wallet record, @Param("example") walletExample example);

    int updateByPrimaryKeySelective(wallet record);

    int updateByPrimaryKey(wallet record);
}