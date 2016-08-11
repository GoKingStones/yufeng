package com.yufeng.service.impl;

import com.yufeng.algorithm.UUIDGenerator;
import com.yufeng.dao.InternalCodeDao;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.InternalCode;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.RegisterAccountService;

import com.yufeng.util.InternalCodeGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/20.
 */
public class RegisterAccountServiceImpl implements RegisterAccountService{

    @Autowired
    private RegisterAccountDao registerAccountDao;

    public boolean isExistedRegisterAccount(String accountName) {
        int count =registerAccountDao.isExistedRegisterAccount(accountName);
        return count==1?true:false;

    }


    public RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber) {
       return registerAccountDao.getRegisterAccountByPhoneNumber(phoneNumber);
    }

    public RegisterAccount getRegisterAccountByName(String accountName) {
        return registerAccountDao.getRegisterAccount(accountName);
    }

    public boolean isExistedRegisterAccountByPhoneNumber(String phoneNumber) {

        int count =registerAccountDao.isExistedRegisterAccountByPhoneNumber(phoneNumber);
        return count==1?true:false;

    }


    public RegisterAccount insertRegisterAccount(RegisterAccount registerAccount) {


        int result =  registerAccountDao.insertRegisterAccount(registerAccount);
        RegisterAccount registerAccount1=null;

        if(result==1) {
            if(registerAccount.getAccountName()!=null) {
                registerAccount1=registerAccountDao.getRegisterAccount(registerAccount.getAccountName());

            }else {
                registerAccount1=registerAccountDao.getRegisterAccountByPhoneNumber(registerAccount.getPhoneNumber());
            }
        }

        return registerAccount1;

    }

    public RegisterAccount updateRegisterAccount(RegisterAccount registerAccount) {

        int result = registerAccountDao.updateRegisterAccount(registerAccount);
        RegisterAccount registerAccount1=null;
        if(result==1) {
            registerAccount1 =registerAccountDao.getRegisterAccountById(registerAccount.getRegisterAccountId());
        }

        return registerAccount1;
    }


    public boolean deleteRegisterAccount(int registerAccountId) {


        int result = registerAccountDao.deleteRegisterAccount(registerAccountId);


        return result==1?true:false;
    }

}
