package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/2.
 */
public class InterviewServiceEntityControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testGetInterviewServiceEntityByWorkerId() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/interviewService/getInterviewServiceEntityByWorkerId?workerId=1",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

        List<InterviewServiceEntity> interviewServiceEntities=JSON.parseArray(resultModelResponseEntity.getBody().getContent().toString(),InterviewServiceEntity.class);


        System.out.println(interviewServiceEntities);

    }

    @Test
    public void testGetInterviewServiceEntityByInternalCode() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/interviewService/getInterviewServiceEntityByInternalCode?internalCode=ts",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testInsertInterviewServiceEntity() throws Exception {


        InterviewServiceEntity interviewServiceEntity=new InterviewServiceEntity();
        interviewServiceEntity.setDetail("xxx");
        interviewServiceEntity.setInternalCode("hello");
        interviewServiceEntity.setInterviewPlace("天津");
        interviewServiceEntity.setInterviewResult("不通过");
        interviewServiceEntity.setInterviewTime(new Date());
        interviewServiceEntity.setPhotoUrl("Users"+ File.separator+"kingstones");
        interviewServiceEntity.setWorkerId(1);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<InterviewServiceEntity> httpEntity=new HttpEntity<InterviewServiceEntity>(interviewServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/interviewService/insertInterviewServiceEntity",
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
    public void testUpdateInterviewServiceEntity() throws Exception {
        InterviewServiceEntity interviewServiceEntity=new InterviewServiceEntity();
        interviewServiceEntity.setInternalCode("xxxx");
        interviewServiceEntity.setInterviewPlace("shanghai");
        interviewServiceEntity.setWorkerId(1);
        interviewServiceEntity.setId(1);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<InterviewServiceEntity> httpEntity=new HttpEntity<InterviewServiceEntity>(interviewServiceEntity);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/interviewService/updateInterviewServiceEntity",
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
    public void testGetInterviewResultByInternalCode() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/interviewService/getInterviewResultByInternalCode?internalCode=xxx",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }
}