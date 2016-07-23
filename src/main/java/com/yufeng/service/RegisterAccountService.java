package com.yufeng.service;

import com.yufeng.entity.RegisterAccount;

/**
 * Created by kingstones on 16/7/20.
 */
public interface RegisterAccountService {

    boolean isExistedRegisterAccount(String name);
    RegisterAccount getRegisterAccount(String name);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int deleteRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccountPassword(String name,String password);

}
