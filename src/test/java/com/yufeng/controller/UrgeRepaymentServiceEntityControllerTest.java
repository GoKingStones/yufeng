package com.yufeng.controller;

import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/5.
 */
public class UrgeRepaymentServiceEntityControllerTest {


    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";


    @Test
    public void testGetUrgeRepaymentServiceEntityByWorkerId() throws Exception {


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/urgeRepaymentService/getUrgeRepaymentServiceEntityByWorkerId?workerId=1",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testGetUrgeRepaymentServiceEntityByInternalCode() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/urgeRepaymentService/getUrgeRepaymentServiceEntityByInternalCode?internalCode=hello",
                ResultModel.class);
        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testInsertUrgeRepaymentServiceEntity() throws Exception {

        UrgeRepaymentServiceEntity urgeRepaymentServiceEntity=new UrgeRepaymentServiceEntity();
        urgeRepaymentServiceEntity.setDetail("xxx");
        urgeRepaymentServiceEntity.setInternalCode("hello");
        urgeRepaymentServiceEntity.setRepayment(new BigDecimal(142444));
        urgeRepaymentServiceEntity.setUrgeMode("电话催款");
        urgeRepaymentServiceEntity.setUrgeStatus("未还");
        urgeRepaymentServiceEntity.setUrgeTime(new Date());
        urgeRepaymentServiceEntity.setUrgeType("电话催款");
        urgeRepaymentServiceEntity.setWorkerId(1);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UrgeRepaymentServiceEntity> httpEntity=new HttpEntity<UrgeRepaymentServiceEntity>(urgeRepaymentServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/urgeRepaymentService/insertUrgeRepaymentServiceEntity",
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
    public void testUpdateUrgeRepaymentServiceEntity() throws Exception {

        UrgeRepaymentServiceEntity urgeRepaymentServiceEntity=new UrgeRepaymentServiceEntity();
        urgeRepaymentServiceEntity.setId(1);
        urgeRepaymentServiceEntity.setWorkerId(1);
        urgeRepaymentServiceEntity.setRepayment(new BigDecimal(12444));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UrgeRepaymentServiceEntity> httpEntity=new HttpEntity<UrgeRepaymentServiceEntity>(urgeRepaymentServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/urgeRepaymentService/updateUrgeRepaymentServiceEntity",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }
}