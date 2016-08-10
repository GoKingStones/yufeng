package com.yufeng.dao;

import com.yufeng.entity.RegisterAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kingstones on 16/7/16.
 */
public interface RegisterAccountDao {

    RegisterAccount getRegisterAccount(String accountName);
    RegisterAccount getRegisterAccountById(int registerAccountId);
    RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber);
    int isExistedRegisterAccount(String accountName);
    int isExistedRegisterAccountByPhoneNumber(String phoneNumber);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int deleteRegisterAccount(int registerAccountId);
}
