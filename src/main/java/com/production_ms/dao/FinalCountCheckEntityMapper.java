package com.production_ms.dao;

import com.production_ms.bean.FinalCountCheckEntity;

public interface FinalCountCheckEntityMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheckEntity record);

    int insertSelective(FinalCountCheckEntity record);

    FinalCountCheckEntity selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheckEntity record);

    int updateByPrimaryKey(FinalCountCheckEntity record);
}