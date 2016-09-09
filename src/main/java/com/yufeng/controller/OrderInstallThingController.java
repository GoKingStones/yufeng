package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.config.ResultStatus;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.entity.InstallEntity;
import com.yufeng.entity.OrderInstallEntity;
import com.yufeng.service.FastConsumerLoanOrderService;
import com.yufeng.util.OrderStateEnum;
import com.yufeng.util.OrderInterestUtil;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by kingstones on 16/7/16.
 * 用户订单分期查询
 */
@RestController
@RequestMapping("orderInstallThingController")
public class OrderInstallThingController {

    @Autowired
    FastConsumerLoanOrderService fastConsumerLoanOrderService;

    //查询用户的所有未还清分期订单
    @RequestMapping(value = "/getCustomerLeftInstallOrders",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getCustomerLeftInstallOrders(@RequestParam String internalCode) {

        List<OrderInstallEntity> orderInstallEntities;
        return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
    }

    //查询某一个订单的分期情况
    @RequestMapping(value = "/getOrderInstallList",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getOrderInstallList(@RequestParam long orderId) {

        List<InstallEntity> installEntities;
        return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
    }






}
