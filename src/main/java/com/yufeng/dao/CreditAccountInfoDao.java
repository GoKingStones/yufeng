package com.yufeng.dao;

import com.yufeng.entity.CreditAccountInfo;

/**
 * Created by fishyu on 16/8/12.
 */
public interface CreditAccountInfoDao {


    CreditAccountInfo getCreditAccountInfo(String internalCode);
    int isExistedCreditAccountInfo(String internalCode);
    int insertCreditAccountInfo(CreditAccountInfo creditAccountInfo);
    int updateCreditAccountInfo(CreditAccountInfo creditAccountInfo);
    
}