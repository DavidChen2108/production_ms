package com.production_ms.dao;

import com.production_ms.bean.ProcessCountCheckEntity;

public interface ProcessCountCheckEntityMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheckEntity record);

    int insertSelective(ProcessCountCheckEntity record);

    ProcessCountCheckEntity selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheckEntity record);

    int updateByPrimaryKey(ProcessCountCheckEntity record);
}