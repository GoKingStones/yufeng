package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.CustomServiceEntity;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/5.
 */
public class CustomServiceEntityControllerTest {


    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testGetCustomServiceEntityByWorkerId() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/customService/getCustomServiceEntityByWorkerId?workerId=1",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testGetCustomServiceEntityByInternalCode() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/customService/getCustomServiceEntityByInternalCode?internalCode=XXX",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());


    }

    @Test
    public void testInsertCustomServiceEntity() throws Exception {

        CustomServiceEntity customServiceEntity=new CustomServiceEntity();
        customServiceEntity.setDetail("非常好");
        customServiceEntity.setInternalCode("YYYY");
        customServiceEntity.setServiceLevel("满意");
        customServiceEntity.setServiceMode("面谈");
        customServiceEntity.setServiceTime(new Date());
        customServiceEntity.setServiceType("XXX");
        customServiceEntity.setWorkerId(1);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CustomServiceEntity> httpEntity=new HttpEntity<CustomServiceEntity>(customServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/customService/insertCustomServiceEntity",
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
    public void testUpdateCustomServiceEntity() throws Exception {

        CustomServiceEntity customServiceEntity=new CustomServiceEntity();
        customServiceEntity.setDetail("非常好");
        customServiceEntity.setInternalCode("YYYY");
        customServiceEntity.setServiceLevel("满意");
        customServiceEntity.setWorkerId(1);
        customServiceEntity.setId(3);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CustomServiceEntity> httpEntity=new HttpEntity<CustomServiceEntity>(customServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/customService/updateCustomServiceEntity",
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