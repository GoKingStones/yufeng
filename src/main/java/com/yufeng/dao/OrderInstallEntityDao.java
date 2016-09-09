package com.yufeng.dao;

import com.yufeng.entity.OrderInstallEntity;

import java.util.List;

/**
 * Created by kingstones on 16/9/7.
 * 用户分期订单DAO
 */
public interface OrderInstallEntityDao {

    //通过客户内码查询未还清分期订单
    public List<OrderInstallEntity> getLeftOrderInstallEntityListByCustomerCode(String internalCode);

    //修改分期订单
    public int updateOrderInstallEntity(OrderInstallEntity orderInstallEntity);

    //插入分期订单
    public int insertOrderInstallEntity(OrderInstallEntity orderInstallEntity);

}
