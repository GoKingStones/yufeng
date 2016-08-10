package com.yufeng.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yufeng.config.Constants;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.util.ResultModel;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.jvm.hotspot.opto.MachSafePointNode;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/8/10.
 */
public class RegisterAccountControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

    @Test
    public void testIsExistedRegisterAccount() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> map=new HashMap<String,String>();
        String accountName="ROOT";
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.getForEntity(REST_SERVICE_URI + "/registerAccount/isExistedRegisterAccount",
                ResultModel.class,accountName);

        // ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "/loginByAccoutName", registerAccount,ResultModel.class);
        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());

    }

    @Test
    public void testIsExistedRegisterAccountByPhoneNumber() throws Exception {

    }

    @Test
    public void testInsertRegisterAccount() throws Exception {

    }

    @Test
    public void testUpdateRegisterAccount() throws Exception {

    }

    @Test
    public void testLoginByAccoutName() throws Exception {

        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountName("ROOT");
        registerAccount.setPassword("aaa");
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.AUTHORIZATION,"1_hahah");
        HttpEntity<RegisterAccount> httpEntity=new HttpEntity<RegisterAccount>(registerAccount,headers);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/registerAccount/loginByAccoutName",
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
    public void testLoginByPhoneNumber() throws Exception {

    }

    @Test
    public void testLogout() throws Exception {

        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountName("ROOT");
        registerAccount.setPassword("aaa");
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.AUTHORIZATION,"1_hahah");
        HttpEntity<RegisterAccount> httpEntity=new HttpEntity<RegisterAccount>(registerAccount,headers);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/registerAccount/logout",
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