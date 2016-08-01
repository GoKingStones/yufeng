package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.RegisterAccountService;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Created by kingstones on 16/7/16.
 */
@RestController
public class RegisterAccountController {

    @Autowired
    private RegisterAccountService registerAccountService;

    @RequestMapping("isExistedRegisterAccount")

    public Map<String,String> isExistedRegisterAccount(@RequestParam("name") String name) {

        boolean result = registerAccountService.isExistedRegisterAccount(name);
        return null;
    }

    @RequestMapping("isExistedRegisterAccountByPhoneNumber")
    public Map<String,String> isExistedRegisterAccountByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {

        boolean result = registerAccountService.isExistedRegisterAccountByPhoneNumber(phoneNumber);
        return null;
    }


    @RequestMapping("getRegisterAccountByName")
    public RegisterAccount getRegisterAccountByName(@RequestParam("name") String name){

        RegisterAccount registerAccount= registerAccountService.getRegisterAccount(name);
        registerAccount.setPassword(MD5Util.convertMD5(MD5Util.convertMD5(registerAccount.getPassword())));
        return registerAccount;
    }

    @RequestMapping("getRegisterAccountByPhoneNumber")
    public RegisterAccount getRegisterAccountByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){

        RegisterAccount registerAccount= registerAccountService.getRegisterAccountByPhoneNumber(phoneNumber);
        registerAccount.setPassword(MD5Util.convertMD5(MD5Util.convertMD5(registerAccount.getPassword())));
        return registerAccount;
    }

    @RequestMapping("insertRegisterAccount")
    @ResponseBody
    public Map<String,String> insertRegisterAccount(@RequestBody RegisterAccount registerAccount){


        ResultMap resultMap=new ResultMap();

        System.out.println(registerAccount);

        registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));
        int result = registerAccountService.insertRegisterAccount(registerAccount);

        if (result==0) {
            return resultMap.getErrorMap();
        }else {
            return resultMap.getSuccessMap();
        }
    }

    @RequestMapping("updateRegisterAccountPassword")
    public Map<String,String> updateRegisterAccountPassword(@RequestParam("name") String name,String password){

        ResultMap resultMap=new ResultMap();
        int result=registerAccountService.updateRegisterAccountPassword(name,MD5Util.string2MD5(password));
        if (result==0) {
            return resultMap.getErrorMap();
        }else {
            return resultMap.getSuccessMap();
        }
    }


    @RequestMapping("updateRegisterAccountInternalCodeByPhoneNumber")
    public Map<String,String> updateRegisterAccountInternalCodeByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber,String password){

        ResultMap resultMap=new ResultMap();
        int result=registerAccountService.updateRegisterAccountPasswordByPhoneNumber(phoneNumber,MD5Util.string2MD5(password));
        if (result==0) {
            return resultMap.getErrorMap();
        }else {
            return resultMap.getSuccessMap();
        }
    }


}
