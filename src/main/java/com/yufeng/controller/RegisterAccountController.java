package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.authorization.annotation.Authorization;
import com.yufeng.authorization.annotation.CurrentUser;
import com.yufeng.config.ResultStatus;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.TokenModel;
import com.yufeng.service.RegisterAccountService;
import com.yufeng.service.TokenModelService;
import com.yufeng.util.ResultMap;
import com.yufeng.util.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Map;


/**
 * Created by kingstones on 16/7/16.
 * 用户信息controller层
 */
@RestController
@RequestMapping("registerAccount")
public class RegisterAccountController {


    @Autowired
    private RegisterAccountService registerAccountService;

    @Autowired
    private TokenModelService tokenModelService;

    @RequestMapping(value = "/isExistedRegisterAccount",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> isExistedRegisterAccount(@RequestParam("accountName") String accountName) {

        boolean result = registerAccountService.isExistedRegisterAccount(accountName);
        if(result) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/isExistedRegisterAccountByPhoneNumber",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> isExistedRegisterAccountByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {

        boolean result = registerAccountService.isExistedRegisterAccountByPhoneNumber(phoneNumber);
        if(result) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }
    }



    @RequestMapping(value = "/insertRegisterAccount",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> insertRegisterAccount(@RequestBody RegisterAccount registerAccount){

        String accountName = registerAccount.getAccountName();
        String phoneNumber = registerAccount.getPhoneNumber();
        if(accountName==null&&phoneNumber==null||accountName!=null&&phoneNumber!=null) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BAD_REQUEST),HttpStatus.OK);
        }else {
            if(accountName!=null) {
                boolean result = registerAccountService.isExistedRegisterAccount(accountName);
                if(result) {
                    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
                }else {
                    registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));

                    RegisterAccount registerAccount1 = registerAccountService.insertRegisterAccount(registerAccount);
                    if (registerAccount1!=null) {
                        return new ResponseEntity<ResultModel>(ResultModel.ok(registerAccount1),HttpStatus.OK);
                    }else {
                        return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
                    }
                }
            }else {
                boolean result = registerAccountService.isExistedRegisterAccountByPhoneNumber(phoneNumber);
                if(result) {
                    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
                }else {
                    registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));

                    RegisterAccount registerAccount1 = registerAccountService.insertRegisterAccount(registerAccount);
                    if (registerAccount1!=null) {
                        return new ResponseEntity<ResultModel>(ResultModel.ok(registerAccount1),HttpStatus.OK);
                    }else {
                        return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
                    }
                }
            }


        }

    }

    @RequestMapping(value = "/updateRegisterAccount",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> updateRegisterAccount(@RequestBody RegisterAccount registerAccount) {


        String accountName = registerAccount.getAccountName();
        String phoneNumber = registerAccount.getPhoneNumber();

        if (registerAccount.getPassword() != null) {
            registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));
        }

        if(accountName!=null&&phoneNumber==null) {
            boolean result = registerAccountService.isExistedRegisterAccount(accountName);
            if(result) {
                return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
            }else {
                registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));

                RegisterAccount registerAccount1 = registerAccountService.updateRegisterAccount(registerAccount);
                if (registerAccount1!=null) {
                    return new ResponseEntity<ResultModel>(ResultModel.ok(registerAccount1),HttpStatus.OK);
                }else {
                    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
                }
            }
        }else if(accountName==null&&phoneNumber!=null){
            boolean result = registerAccountService.isExistedRegisterAccountByPhoneNumber(phoneNumber);
            if(result) {
                return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
            }else {
                registerAccount.setPassword(MD5Util.string2MD5(registerAccount.getPassword()));

                RegisterAccount registerAccount1 = registerAccountService.updateRegisterAccount(registerAccount);
                if (registerAccount1!=null) {
                    return new ResponseEntity<ResultModel>(ResultModel.ok(registerAccount1),HttpStatus.OK);
                }else {
                    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
                }
            }
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BAD_REQUEST),HttpStatus.OK);
        }



    }


    @RequestMapping(value="/loginByAccoutName",method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<ResultModel> loginByAccoutName(@RequestBody RegisterAccount registerAccount) {
        Assert.notNull(registerAccount.getAccountName(), "accountName can not be empty");
        Assert.notNull(registerAccount.getPassword(), "password can not be empty");

        RegisterAccount registerAccount1=registerAccountService.getRegisterAccountByName(registerAccount.getAccountName());
        if (registerAccount1== null ||  //未注册
                !MD5Util.convertMD5(registerAccount.getPassword()).equals(registerAccount1.getPassword())) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.OK);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenModelService.createToken(registerAccount1.getRegisterAccountId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(value="/loginByPhoneNumber",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> loginByPhoneNumber(@RequestParam String phoneNumber, @RequestParam String password) {
        Assert.notNull(phoneNumber, "phoneNumber can not be empty");
        Assert.notNull(password, "password can not be empty");

        RegisterAccount registerAccount=registerAccountService.getRegisterAccountByPhoneNumber(phoneNumber);
        if (registerAccount == null ||  //未注册
                !MD5Util.convertMD5(registerAccount.getPassword()).equals(password)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenModelService.createToken(registerAccount.getRegisterAccountId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(model), HttpStatus.OK);
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<ResultModel> logout(@CurrentUser RegisterAccount registerAccount) {
        tokenModelService.deleteToken(registerAccount.getRegisterAccountId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(), HttpStatus.OK);
    }


}
