package com.yufeng.controller;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;
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
 * Created by kingstones on 16/9/1.
 */
public class EnterpriseBusinessBasicInfoControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testGetEnterpriseBusinessBasicInfo() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/enterpriseBusinessBasicInfo/getEnterpriseBusinessBasicInfo?internalCode=MDEyMDEwMDE1OTEyOTYyMDI0ODg=",
                ResultModel.class);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());


    }

    @Test
    public void testInsertEnterpriseBusinessBasicInfo() throws Exception {

        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo=new EnterpriseBusinessBasicInfo();
        enterpriseBusinessBasicInfo.setBusinessName("蒂芙尼");
        enterpriseBusinessBasicInfo.setEnterpriseName("蒂芙尼");
        enterpriseBusinessBasicInfo.setBusinessCreditValue(0);
        enterpriseBusinessBasicInfo.setBusinessScore(100);
        enterpriseBusinessBasicInfo.setBusinessBrand("奢侈品");
        enterpriseBusinessBasicInfo.setBusinessLicenceManagementScope("10000330");
        enterpriseBusinessBasicInfo.setBusinessLicenseNumber("123456");
        enterpriseBusinessBasicInfo.setBusinessRank("中等");
        enterpriseBusinessBasicInfo.setEmail("339192618");
        enterpriseBusinessBasicInfo.setEnterpriseAddr("天津市塘沽区");
        enterpriseBusinessBasicInfo.setFax("11122");
        enterpriseBusinessBasicInfo.setLegalPersonCertificateNumber("150125198912025318");
        enterpriseBusinessBasicInfo.setLegalPersonCertificateType(0);
        enterpriseBusinessBasicInfo.setManageContactName("王磊");
        enterpriseBusinessBasicInfo.setManageContactTel("18727273737");
        enterpriseBusinessBasicInfo.setOpenTime(new Date());
        enterpriseBusinessBasicInfo.setRegisteredCapital(new BigDecimal(222.222));
        enterpriseBusinessBasicInfo.setLegalPersonName("王磊");
        enterpriseBusinessBasicInfo.setWebsite("www.xxx.com");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<EnterpriseBusinessBasicInfo> httpEntity=new HttpEntity<EnterpriseBusinessBasicInfo>(enterpriseBusinessBasicInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/enterpriseBusinessBasicInfo/insertEnterpriseBusinessBasicInfo",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testUpdateEnterpriseBusinessBasicInfo() throws Exception {

        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo=new EnterpriseBusinessBasicInfo();
        enterpriseBusinessBasicInfo.setInternalCode("MDEyMDEwMDE1OTEyOTYyMDI0ODg=");
        enterpriseBusinessBasicInfo.setBusinessBrand("xxx");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<EnterpriseBusinessBasicInfo> httpEntity=new HttpEntity<EnterpriseBusinessBasicInfo>(enterpriseBusinessBasicInfo);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/enterpriseBusinessBasicInfo/updateEnterpriseBusinessBasicInfo",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }
}