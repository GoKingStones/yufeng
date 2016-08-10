package com.yufeng.service;

import com.yufeng.entity.RegisterAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kingstones on 16/7/20.
 */
public interface RegisterAccountService {

    boolean isExistedRegisterAccount(String accountName);
    boolean isExistedRegisterAccountByPhoneNumber(String phoneNumber);
    RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber);
    RegisterAccount getRegisterAccountByName(String accountName);
    RegisterAccount insertRegisterAccount(RegisterAccount registerAccount);
    RegisterAccount updateRegisterAccount(RegisterAccount registerAccount);
    boolean deleteRegisterAccount(int registerAccountId);

}
