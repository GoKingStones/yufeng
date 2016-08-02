package com.yufeng.service;

import com.yufeng.entity.RegisterAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kingstones on 16/7/20.
 */
public interface RegisterAccountService {

    boolean isExistedRegisterAccount(String name);
    boolean isExistedRegisterAccountByPhoneNumber(String phoneNumber);
    RegisterAccount getRegisterAccount(String name);
    RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccountPasswordByPhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("password")String password);
    int deleteRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccountPassword(String name,String password);

}
