package com.yufeng.dao;

import com.yufeng.entity.BOCCancelOrderEntity;
import com.yufeng.entity.BOCLoanOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费取消的订单DAO
 */
public interface BOCCancelOrderDao {

    //添加
    public int insertBOCCancelOrder(BOCCancelOrderEntity bocCancelOrderEntity);

}
