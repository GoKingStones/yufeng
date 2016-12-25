package com.yufeng.dao;

import com.yufeng.entity.BOCLoanOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费还款订单DAO
 */
public interface BOCPayOrderDao {

    //添加还款订单明细
    public int insertBOCLoanOrder(BOCLoanOrderEntity bocLoanOrderEntity);



}
