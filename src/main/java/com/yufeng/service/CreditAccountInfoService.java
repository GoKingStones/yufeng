package com.yufeng.service;

import com.yufeng.entity.CreditAccountInfo;

/**
 * Created by fishyu on 16/8/12s.
 */
public interface CreditAccountInfoService {

    CreditAccountInfo getCreditAccountInfo(String internalCode);
    boolean isExistedCreditAccountInfo(String internalCode);
    CreditAccountInfo insertOrUpdateCreditAccountInfo(String internalCode,String accountType);
    CreditAccountInfo updateCreditAccountInfo(CreditAccountInfo creditAccountInfo);
}
