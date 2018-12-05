package com.production_ms.dao;

import com.production_ms.bean.FinalMeasureCheckEntity;

public interface FinalMeasureCheckEntityMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasureCheckEntity record);

    int insertSelective(FinalMeasureCheckEntity record);

    FinalMeasureCheckEntity selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasureCheckEntity record);

    int updateByPrimaryKey(FinalMeasureCheckEntity record);
}