package com.production_ms.dao;

import com.production_ms.bean.UnQualifyApplyEntity;

public interface UnQualifyApplyEntityMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnQualifyApplyEntity record);

    int insertSelective(UnQualifyApplyEntity record);

    UnQualifyApplyEntity selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnQualifyApplyEntity record);

    int updateByPrimaryKey(UnQualifyApplyEntity record);
}