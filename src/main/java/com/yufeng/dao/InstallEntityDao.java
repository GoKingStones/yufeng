package com.yufeng.dao;

import com.yufeng.entity.InstallEntity;

import java.util.List;

/**
 * Created by kingstones on 16/9/7.
 * 每期分期订单DAO
 */
public interface InstallEntityDao {

    //通过订单ID获取所有分期列表
    public List<InstallEntity> getInstallEntityListByOrderId(long orderId);

    //插入某期
    public int insertInstallEntity(InstallEntity installEntity);

    //修改某期
    public int updateInstallEntity(InstallEntity installEntity);

}
