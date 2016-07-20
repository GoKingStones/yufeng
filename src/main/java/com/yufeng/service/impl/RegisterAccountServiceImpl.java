package com.yufeng.service.impl;

import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.RegisterAccountService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/20.
 */
public class RegisterAccountServiceImpl implements RegisterAccountService{

    @Autowired
    private RegisterAccountDao registerAccountDao;

    public RegisterAccount getRegisterAccount(String name) {
        return registerAccountDao.getRegisterAccount(name);
    }

    public int insertRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.insertRegisterAccount(registerAccount);
    }

    public int updateRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.updateRegisterAccount(registerAccount);
    }

    public int deleteRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.deleteRegisterAccount(registerAccount);
    }
}
