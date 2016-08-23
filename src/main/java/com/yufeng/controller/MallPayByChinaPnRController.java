package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.algorithm.MD5Util;
import com.yufeng.authorization.annotation.Authorization;
import com.yufeng.authorization.annotation.CurrentUser;
import com.yufeng.config.ResultStatus;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.TokenModel;
import com.yufeng.service.RegisterAccountService;
import com.yufeng.service.TokenModelService;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Created by kingstones on 16/7/16.
 * 汇付相关controller层
 */
@RestController
@RequestMapping("mallPayByChinaPnRController")
public class MallPayByChinaPnRController {

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> isExistedRegisterAccountByPhoneNumber(@RequestParam("params") String params) {

        Map<String,String> map= (Map<String,String>)JSON.parse(params);
        boolean result=true;
        if(result) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/updateRegisterAccount",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> updateRegisterAccount(@RequestBody RegisterAccount registerAccount) {

        return null;
    }



}
