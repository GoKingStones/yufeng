package com.yufeng.dao;

import com.yufeng.entity.BOCLoanAccountEntity;
import com.yufeng.entity.BOCLoanOrderEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费订单DAO
 */
public interface BOCLoanOrderDao {

//    //添加金融订单
//    public int insertBOCLoanOrder(BOCLoanOrderEntity bocLoanOrderEntity);
//
//    //更新金融订单
//    public int updateBOCLoanOrder(BOCLoanOrderDao bocLoanOrderDao);

    public int deleteByPrimaryKey(Integer id);

    public int insert(BOCLoanOrderEntity record);

    public int insertSelective(BOCLoanOrderEntity record);

    public BOCLoanOrderEntity selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(BOCLoanOrderEntity record);

    public int updateByPrimaryKey(BOCLoanOrderEntity record);
    
}
