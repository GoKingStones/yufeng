package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.dto.OrderStateDto;
import com.yufeng.dto.ReturnCommodityDto;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.util.OrderStateEnum;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/19.
 */
public class FastConsumerLoanOrderControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    //public static final String REST_SERVICE_URI = "http://118.178.92.189:8080/yufeng";
    @Test
    public void testGetRepaymentInterest() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        GetOrderInterestDto getOrderInterestDto=new GetOrderInterestDto();
        getOrderInterestDto.setTotalAmount(new BigDecimal(1000));
        getOrderInterestDto.setInstallCount(12);
        getOrderInterestDto.setInstallType("快消品");
        HttpEntity<GetOrderInterestDto> httpEntity=new HttpEntity<GetOrderInterestDto>(getOrderInterestDto);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/fastConsumerLoanOrder/getOrderInterest",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testSubmitOrder() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        FastConsumerLoanOrderDto fastConsumerLoanOrderDto=new FastConsumerLoanOrderDto();
        FastConsumerLoanOrder fastConsumerLoanOrder=new FastConsumerLoanOrder();
        fastConsumerLoanOrder.setInterest(new BigDecimal(10));
        fastConsumerLoanOrder.setTotalAmount(new BigDecimal(1000));
        fastConsumerLoanOrder.setDiscountAmount(new BigDecimal(900));
        fastConsumerLoanOrder.setFreight(new BigDecimal(10));
        fastConsumerLoanOrder.setInstallType("快消品 ");
        fastConsumerLoanOrder.setInstallCount(12);
        fastConsumerLoanOrder.setUserInternalCode("xxxxx");
        fastConsumerLoanOrder.setActualTotalAmount(new BigDecimal(920));
        fastConsumerLoanOrderDto.setFastConsumerLoanOrder(fastConsumerLoanOrder);
        List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity.setCommodityId("100");
        fastConsumerLoanOrderCommodity.setCommodityName("iphone");
        fastConsumerLoanOrderCommodity.setCommodityNumber(1);
        fastConsumerLoanOrderCommodity.setOrderId(0);
        fastConsumerLoanOrderCommodity.setPrice(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setUniqueId("0");
        fastConsumerLoanOrderCommodity.setUserInternalCode("xxxx");

        list.add(fastConsumerLoanOrderCommodity);

        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity1=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity1.setCommodityId("200");
        fastConsumerLoanOrderCommodity1.setCommodityName("sumang");
        fastConsumerLoanOrderCommodity1.setCommodityNumber(2);
        fastConsumerLoanOrderCommodity1.setOrderId(0);
        fastConsumerLoanOrderCommodity1.setPrice(new BigDecimal(1000));
        fastConsumerLoanOrderCommodity1.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity1.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity1.setUniqueId("1");
        fastConsumerLoanOrderCommodity1.setUserInternalCode("xxxx");
        list.add(fastConsumerLoanOrderCommodity1);
        fastConsumerLoanOrderDto.setFastConsumerLoanOrderCommodities(list);
        String json= JSON.toJSONString(fastConsumerLoanOrderDto);

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        System.out.println(type);
        HttpEntity<String> httpEntity=new HttpEntity<String>(json,headers);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/fastConsumerLoanOrder/submitOrder",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }


    @Test
    public void testCancelOrder() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/fastConsumerLoanOrder/cancelOrder?orderId=1",
                ResultModel.class);
        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testReturnOrder() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/fastConsumerLoanOrder/returnOrder?orderId=0",
                ResultModel.class);
        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());



    }

    @Test
    public void testReturnCommodity() throws Exception {


        RestTemplate restTemplate = new RestTemplate();


        ReturnCommodityDto returnCommodityDto=new ReturnCommodityDto();
        returnCommodityDto.setOrderId(0);
        List<String> list=new ArrayList<String>();
        list.add("0");
        returnCommodityDto.setCommodityIdList(list);
        String params=JSON.toJSONString(returnCommodityDto);
        HttpEntity<String> httpEntity=new HttpEntity<String>(params);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/fastConsumerLoanOrder/returnCommodity",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testUpdateOrderState() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        OrderStateDto orderStateDto=new OrderStateDto();
        orderStateDto.setOrderId(0);
        orderStateDto.setOrderState(OrderStateEnum.部分退货.name());
        String orderStateInfo=JSON.toJSONString(orderStateDto);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        System.out.println(type);
        HttpEntity<String> httpEntity=new HttpEntity<String>(orderStateInfo,headers);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/fastConsumerLoanOrder/updateOrderState",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testQueryOrderState() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/fastConsumerLoanOrder/queryOrderState?orderId=4",
                ResultModel.class);
        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());


    }
}