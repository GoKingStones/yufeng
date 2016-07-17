package com.yufeng.controller;

import com.yufeng.entity.RegisterAccount;
import com.yufeng.dao.RegisterAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by kingstones on 16/7/16.
 */
@RestController
public class RegisterAccountController {

    @Autowired
    private RegisterAccountDao registerAccountDao;

    @RequestMapping("getRegisterAccountByName")
    public RegisterAccount getRegisterAccountByName(@RequestParam("name") String name){

        RegisterAccount registerAccount= registerAccountDao.getRegisterAccount(name);
        return registerAccount;
    }

}
