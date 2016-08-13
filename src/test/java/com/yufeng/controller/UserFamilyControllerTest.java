package com.yufeng.controller;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;

/**
 * 用户家庭联系人控制层测试类
 * @author dh
 */
public class UserFamilyControllerTest {
	
    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	@Test
    public void testGetUserFamilyByCode() throws Exception {
        //参数
    	String parameter="code=fff";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFamily/getUserFamilyByCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testGetUserFamilyById() throws Exception {
        //参数
    	String parameter="id=1";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFamily/getUserFamilyById?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testInsertUserFamilyInfo() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
		//参数
    	UserFamilyInfo userFamilyInfo=new UserFamilyInfo();
    	userFamilyInfo.setCredentialsNumber("11");
    	userFamilyInfo.setCredentialsType("11");
    	userFamilyInfo.setGender("11");
    	userFamilyInfo.setHighestEducation("11");
    	userFamilyInfo.setHighestEducationSchool("11");
    	userFamilyInfo.setInternal_code("11");
    	userFamilyInfo.setMailbox("11");
    	userFamilyInfo.setMailingAddress("11");
    	userFamilyInfo.setName("11");
    	userFamilyInfo.setOrganization("11");
    	userFamilyInfo.setPhone("11");
    	userFamilyInfo.setRelation("11");
    	
        HttpEntity<UserFamilyInfo> httpEntity=new HttpEntity<UserFamilyInfo>(userFamilyInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/insertUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testUpdateUserFamilyInfo() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
		//参数
    	UserFamilyInfo userFamilyInfo=new UserFamilyInfo();
    	userFamilyInfo.setCredentialsNumber("22");
    	userFamilyInfo.setCredentialsType("22");
    	userFamilyInfo.setGender("22");
    	userFamilyInfo.setHighestEducation("22");
    	userFamilyInfo.setHighestEducationSchool("22");
    	userFamilyInfo.setInternal_code("22");
    	userFamilyInfo.setMailbox("22");
    	userFamilyInfo.setMailingAddress("22");
    	userFamilyInfo.setName("22");
    	userFamilyInfo.setOrganization("22");
    	userFamilyInfo.setPhone("22");
    	userFamilyInfo.setRelation("22");
    	
        HttpEntity<UserFamilyInfo> httpEntity=new HttpEntity<UserFamilyInfo>(userFamilyInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/updateUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testDeleteUserFamilyInfo() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserFamilyHistoryInfo userFamilyHistoryInfo=new UserFamilyHistoryInfo();
    	userFamilyHistoryInfo.setId("4");
    	userFamilyHistoryInfo.setDelete_operator("hehe");

        HttpEntity<UserFamilyHistoryInfo> httpEntity=new HttpEntity<UserFamilyHistoryInfo>(userFamilyHistoryInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/deleteUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }

}
