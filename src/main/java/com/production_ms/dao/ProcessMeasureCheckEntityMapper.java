package com.production_ms.dao;

import com.production_ms.bean.ProcessMeasureCheckEntity;

public interface ProcessMeasureCheckEntityMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheckEntity record);

    int insertSelective(ProcessMeasureCheckEntity record);

    ProcessMeasureCheckEntity selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheckEntity record);

    int updateByPrimaryKey(ProcessMeasureCheckEntity record);
}