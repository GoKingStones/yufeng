package com.yufeng.controller;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserFinancialAccountInfo;

/**
 * 用户金融控制层测试类
 * @author dh
 */
public class UserFinancialAccountControllerTest {
	
public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	@Test
    public void testGetUserFinancialAccountByCode() throws Exception {
        //参数
    	String parameter="code=nnn";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFinancialAccount/getUserFinancialAccountByCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testGetUserFinancialAccountById() throws Exception {
        //参数
    	String parameter="id=8";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFinancialAccount/getUserFinancialAccountById?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testInsertUserFinancialAccount() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserFinancialAccountInfo userFinancialAccountInfo=new UserFinancialAccountInfo();
    	userFinancialAccountInfo.setAuthorize("11");
    	userFinancialAccountInfo.setCreditScoring(111);
    	userFinancialAccountInfo.setDelete_operator("11");
    	userFinancialAccountInfo.setFinancialConsumeAccountId("11");
    	userFinancialAccountInfo.setFinancialConsumeAccountState("11");
    	userFinancialAccountInfo.setFinancialConsumeCompany("11");
    	userFinancialAccountInfo.setInfo_status(false);
    	userFinancialAccountInfo.setInternal_code("11");
    	userFinancialAccountInfo.setSignId("11");
    	
        HttpEntity<UserFinancialAccountInfo> httpEntity=new HttpEntity<UserFinancialAccountInfo>(userFinancialAccountInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFinancialAccount/insertUserFinancialAccount",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testUpdateUserFinancialAccount() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserFinancialAccountInfo userFinancialAccountInfo=new UserFinancialAccountInfo();
    	userFinancialAccountInfo.setCreditScoring(222);
    	userFinancialAccountInfo.setAuthorize("22");
    	userFinancialAccountInfo.setDelete_operator("22");
    	userFinancialAccountInfo.setFinancialConsumeAccountId("22");
    	userFinancialAccountInfo.setFinancialConsumeAccountState("22");
    	userFinancialAccountInfo.setFinancialConsumeCompany("22");
    	userFinancialAccountInfo.setInfo_status(false);
    	userFinancialAccountInfo.setInternal_code("22");
    	userFinancialAccountInfo.setSignId("22");
    	userFinancialAccountInfo.setId("14");
    	
        HttpEntity<UserFinancialAccountInfo> httpEntity=new HttpEntity<UserFinancialAccountInfo>(userFinancialAccountInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFinancialAccount/updateUserFinancialAccount",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testDeleteUserFinancialAccount() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserFinancialAccountInfo userFinancialAccountInfo=new UserFinancialAccountInfo();
    	userFinancialAccountInfo.setId("14");
    	userFinancialAccountInfo.setDelete_operator("bbb");
    	
    	HttpEntity<UserFinancialAccountInfo> httpEntity=new HttpEntity<UserFinancialAccountInfo>(userFinancialAccountInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFinancialAccount/deleteUserFinancialAccount",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }

}
