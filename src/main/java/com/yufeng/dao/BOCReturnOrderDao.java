package com.yufeng.dao;

import com.yufeng.entity.BOCLoanOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费退货的订单DAO
 */
public interface BOCReturnOrderDao {

    //添加退货订单明细
    public int insertBOCLoanOrder(BOCLoanOrderEntity bocLoanOrderEntity);

}
