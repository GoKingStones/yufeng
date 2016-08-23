package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.config.ResultStatus;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.FastConsumerLoanOrderService;
import com.yufeng.util.CommodityStateEnum;
import com.yufeng.util.InterestAndFee;
import com.yufeng.util.RepaymentInterestUtil;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Created by kingstones on 16/7/16.
 * 商城订单支付controller层
 */
@RestController
@RequestMapping("mallPay")
public class MallPayController {

    @Autowired
    FastConsumerLoanOrderService fastConsumerLoanOrderService;


    //通过订单获取总的利息，这个接口暂时保留
    @RequestMapping(value = "/getRepaymentInterest",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> getRepaymentInterest(String params) {

        BigDecimal interests=new BigDecimal(0);
        Map<String,Object> order= (Map<String,Object>)JSON.parse(params);
        String installCount = order.get("installCount").toString();
        List<FastConsumerLoanOrderCommodity> lists=(List)order.get("commodities");
        for(int i=0;i<lists.size();i++) {

            FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity=lists.get(i);
            //通过产品和产品类别获取利息
            RepaymentInterestUtil repaymentInterestUtil=new RepaymentInterestUtil();
            InterestAndFee interestAndFee = repaymentInterestUtil.get(Integer.valueOf(installCount), fastConsumerLoanOrderCommodity);
            interests.add(interestAndFee.getInterest());
        }

        return new ResponseEntity<ResultModel>(ResultModel.ok(interests),HttpStatus.OK);

    }

    //用户提交订单
    @RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> submitOrder(String params) {

        FastConsumerLoanOrderDto map= (FastConsumerLoanOrderDto)JSON.parse(params);

        //更新订单表和更新商品表，请款申请表


        boolean result=true;
        if(result) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }
    }

    //用户商品状态变更
    @RequestMapping(value = "/updateCommodityState",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> updateCommodityState(String params) {

        FastConsumerLoanOrderDto order= (FastConsumerLoanOrderDto)JSON.parse(params);

        List<FastConsumerLoanOrderCommodity> lists=order.getFastConsumerLoanOrderCommodities();
        for(int i=0;i<lists.size();i++) {

            FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity=lists.get(i);
            String state =fastConsumerLoanOrderCommodity.getInformation_state();
            if(state.equals(CommodityStateEnum.已提交.name())) {


            }else if (state.equals(CommodityStateEnum.已取消.name())) {

            }else if (state.equals(CommodityStateEnum.已发货.name())) {

            }else if (state.equals(CommodityStateEnum.已收货.name())) {

            }else if (state.equals(CommodityStateEnum.订单完成.name())) {

            }else {

            }
        }


        return null;
    }






}
