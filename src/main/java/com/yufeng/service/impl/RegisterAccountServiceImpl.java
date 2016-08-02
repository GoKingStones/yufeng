package com.yufeng.service.impl;

import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.RegisterAccountService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/20.
 */
public class RegisterAccountServiceImpl implements RegisterAccountService{

    @Autowired
    private RegisterAccountDao registerAccountDao;

    public boolean isExistedRegisterAccount(String name) {
        int count =registerAccountDao.isExistedRegisterAccount(name);
        boolean result =false;
        if(count !=0) result=true;
        return result;

    }

    public boolean isExistedRegisterAccountByPhoneNumber(String phoneNumber) {

        int count =registerAccountDao.isExistedRegisterAccountByPhoneNumber(phoneNumber);
        boolean result =false;
        if(count !=0) result=true;
        return result;


    }


    public RegisterAccount getRegisterAccount(String name) {
        return registerAccountDao.getRegisterAccount(name);
    }

    public RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber) {
        return registerAccountDao.getRegisterAccountByPhoneNumber(phoneNumber);
    }

    public int insertRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.insertRegisterAccount(registerAccount);
    }

    public int updateRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.updateRegisterAccount(registerAccount);
    }

    public int updateRegisterAccountPasswordByPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("password") String password) {
        return registerAccountDao.updateRegisterAccountPasswordByPhoneNumber(phoneNumber, password);
    }

    public int deleteRegisterAccount(RegisterAccount registerAccount) {
        return registerAccountDao.deleteRegisterAccount(registerAccount);
    }

    public int updateRegisterAccountPassword(String name, String password) {

        int result=0;
        if(registerAccountDao.getRegisterAccount(name)!=null) {
            result = registerAccountDao.updateRegisterAccountPassword(name, password);
        }

        return result;
    }
}
