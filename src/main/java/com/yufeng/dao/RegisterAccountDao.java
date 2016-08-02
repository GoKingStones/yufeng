package com.yufeng.dao;

import com.yufeng.entity.RegisterAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kingstones on 16/7/16.
 */
public interface RegisterAccountDao {

    RegisterAccount getRegisterAccount(String name);
    RegisterAccount getRegisterAccountByPhoneNumber(String phoneNumber);
    int isExistedRegisterAccount(String name);
    int isExistedRegisterAccountByPhoneNumber(String phoneNumber);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int deleteRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccountPassword(@Param("name")String name,@Param("password")String password);
    int updateRegisterAccountPasswordByPhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("password")String password);
    int updateRegisterAccountInternalCode(@Param("name")String name,@Param("internalCode")String internalCode);
    int updateRegisterAccountInternalCodeByPhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("internalCode")String internalCode);
}
