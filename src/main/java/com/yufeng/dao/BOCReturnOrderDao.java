package com.yufeng.dao;

import com.yufeng.entity.BOCLoanOrderEntity;
import com.yufeng.entity.BOCReturnOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费退货的订单DAO
 */
public interface BOCReturnOrderDao {

//    //添加退货订单明细
//    public int insertBOCLoanOrder(BOCLoanOrderEntity bocLoanOrderEntity);
    
    public int deleteByPrimaryKey(Integer id);

    public int insert(BOCReturnOrderEntity record);

    public int insertSelective(BOCReturnOrderEntity record);

    public BOCReturnOrderEntity selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(BOCReturnOrderEntity record);

    public int updateByPrimaryKey(BOCReturnOrderEntity record);

}
