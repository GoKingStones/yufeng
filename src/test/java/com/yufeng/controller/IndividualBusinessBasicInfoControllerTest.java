package com.yufeng.controller;

import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/5.
 */
public class IndividualBusinessBasicInfoControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testGetIndividualBusinessBasicInfo() throws Exception {


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/individualBusinessBasicInfo/getIndividualBusinessBasicInfo?internalCode=MDEyMDEwMDE1OTEyOTYyMDI0ODg=",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());


    }

    @Test
    public void testInsertIndividualBusinessBasicInfo() throws Exception {

        IndividualBusinessBasicInfo individualBusinessBasicInfo=new IndividualBusinessBasicInfo();
        individualBusinessBasicInfo.setShopName("熊猫小店");
        individualBusinessBasicInfo.setLocalArea("天津");
        individualBusinessBasicInfo.setOpenTime(new Date());
        individualBusinessBasicInfo.setShopAddr("塘沽");
        individualBusinessBasicInfo.setShopCreditValue(22);
        individualBusinessBasicInfo.setShopkeeperCertificateNumber("150125198912025318");
        individualBusinessBasicInfo.setShopkeeperCertificateType(0);
        individualBusinessBasicInfo.setShopkeeperName("王磊");
        individualBusinessBasicInfo.setShopRank("333");
        individualBusinessBasicInfo.setShopScope(222);
        individualBusinessBasicInfo.setShopStatus("yiyan");
        individualBusinessBasicInfo.setShopTel("13883732712");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IndividualBusinessBasicInfo> httpEntity=new HttpEntity<IndividualBusinessBasicInfo>(individualBusinessBasicInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/individualBusinessBasicInfo/insertIndividualBusinessBasicInfo",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testUpdateIndividualBusinessBasicInfo() throws Exception {

        IndividualBusinessBasicInfo individualBusinessBasicInfo=new IndividualBusinessBasicInfo();
        individualBusinessBasicInfo.setShopName("laolishi");
        individualBusinessBasicInfo.setInternalCode("MDEyMDEwMDE1OTEyOTYyMDI0ODg=");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<IndividualBusinessBasicInfo> httpEntity=new HttpEntity<IndividualBusinessBasicInfo>(individualBusinessBasicInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/individualBusinessBasicInfo/updateIndividualBusinessBasicInfo",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());


    }
}