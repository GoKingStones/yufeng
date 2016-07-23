package com.yufeng.dao;

import com.yufeng.entity.RegisterAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kingstones on 16/7/16.
 */
public interface RegisterAccountDao {

    RegisterAccount getRegisterAccount(String name);
    int isExistedRegisterAccount(String name);
    int insertRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccount(RegisterAccount registerAccount);
    int deleteRegisterAccount(RegisterAccount registerAccount);
    int updateRegisterAccountPassword(@Param("name")String name,@Param("password")String password);
}
