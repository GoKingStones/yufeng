package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/5.
 */
public class WorkerInfoControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testGetWorkerInfoByWorkerName() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/workerInfo/getWorkerInfoByWorkerName?workerName=小",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
    }

    @Test
    public void testGetWorkerInfoByPhoneNumber() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/workerInfo/getWorkerInfoByPhoneNumber?phoneNumber=1382847372",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testInsertWorkerInfo() throws Exception {

        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setCategory("XX");
        workerInfo.setCreator("ADMIN");
        workerInfo.setEmail("33992991@");
        workerInfo.setIdNumber("150125198912025318");
        workerInfo.setIdType("0");
        workerInfo.setOrgId("XXX");
        workerInfo.setPassword("123456");
        workerInfo.setPhoneNumber("13827847372");
        workerInfo.setPositionLevel("HZONGJI");
        workerInfo.setWeixinNo("3929291");
        workerInfo.setWorkerName("小张");
        workerInfo.setWorkerPosition("中级");
        workerInfo.setWorkerStatus("在职");
        workerInfo.setWorkPhone("13827277221");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<WorkerInfo> httpEntity=new HttpEntity<WorkerInfo>(workerInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/workerInfo/insertWorkerInfo",
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
    public void testUpdateWorkerInfo() throws Exception {

        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setWorkerId(2);
        workerInfo.setEmail("23992991@");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<WorkerInfo> httpEntity=new HttpEntity<WorkerInfo>(workerInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/workerInfo/updateWorkerInfo",
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
    public void testUpdateWorkerInfoByAdmin() throws Exception {

        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setWorkerId(2);
        workerInfo.setWorkerName("李斯");
        workerInfo.setEmail("23992991@");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<WorkerInfo> httpEntity=new HttpEntity<WorkerInfo>(workerInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/workerInfo/updateWorkerInfoByAdmin",
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