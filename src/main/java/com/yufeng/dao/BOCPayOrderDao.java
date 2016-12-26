package com.yufeng.dao;

import com.yufeng.entity.BOCLoanOrderEntity;
import com.yufeng.entity.BOCPayOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费还款订单DAO
 */
public interface BOCPayOrderDao {

//    //添加还款订单明细
//    public int insertBOCLoanOrder(BOCLoanOrderEntity bocLoanOrderEntity);
    
    public int deleteByPrimaryKey(Integer id);

    public int insert(BOCPayOrderEntity record);

    public int insertSelective(BOCPayOrderEntity record);

    public BOCPayOrderEntity selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(BOCPayOrderEntity record);

    public int updateByPrimaryKey(BOCPayOrderEntity record);



}
