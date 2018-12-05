package com.production_ms.dao;

import com.production_ms.bean.DeviceCheckEntity;

public interface DeviceCheckEntityMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheckEntity record);

    int insertSelective(DeviceCheckEntity record);

    DeviceCheckEntity selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheckEntity record);

    int updateByPrimaryKey(DeviceCheckEntity record);
}