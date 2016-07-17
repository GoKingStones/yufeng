package com.yufeng.dao;

import com.yufeng.entity.RegisterAccount;

/**
 * Created by kingstones on 16/7/16.
 */
public interface RegisterAccountDao {

    RegisterAccount getRegisterAccount(String name);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int deleteRegisterAccount(RegisterAccount registerAccount);
}
