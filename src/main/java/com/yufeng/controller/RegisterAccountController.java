package com.yufeng.controller;

import com.yufeng.entity.RegisterAccount;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.service.RegisterAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by kingstones on 16/7/16.
 */
@RestController
public class RegisterAccountController {

    @Autowired
    private RegisterAccountService registerAccountService;

    @RequestMapping("getRegisterAccountByName")
    public RegisterAccount getRegisterAccountByName(@RequestParam("name") String name){

        RegisterAccount registerAccount= registerAccountService.getRegisterAccount(name);
        return registerAccount;
    }

    @RequestMapping("insertRegisterAccount")
    @ResponseBody
    public void insertRegisterAccount(@RequestBody RegisterAccount body){
        System.out.println(body);
        int count = registerAccountService.insertRegisterAccount(body);

        if(count!=1) {
            System.out.println("insert error");
        }

    }

}
