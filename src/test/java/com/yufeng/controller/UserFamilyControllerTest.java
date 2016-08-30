package com.yufeng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	//@Test
    public void testGetUserFamilyByCode() throws Exception {
        //参数
    	String parameter="internalCode=fff";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFamily/getUserFamilyByInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testGetUserFamilyById() throws Exception {
        //参数
    	String parameter="uniqueId=5&internalCode=fff";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/UserFamily/getUserFamilyByIdAndInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testInsertUserFamilyInfo() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
		//参数
    	UserFamilyInfo userFamilyInfo=new UserFamilyInfo();
    	userFamilyInfo.setCredentialsNumber("1144");
    	userFamilyInfo.setCredentialsType("11");
    	userFamilyInfo.setGender("11");
    	userFamilyInfo.setHighestEducation("11");
    	userFamilyInfo.setHighestEducationSchool("11");
    	userFamilyInfo.setInternalCode("11");
    	userFamilyInfo.setEmail("11");
    	userFamilyInfo.setMailingAddress("11");
    	userFamilyInfo.setName("11");
    	userFamilyInfo.setOrganization("11");
    	userFamilyInfo.setCellNo("11");
    	userFamilyInfo.setRelation("11");
    	List<UserFamilyInfo> list=new ArrayList<UserFamilyInfo>();
    	list.add(userFamilyInfo);
    	
        HttpEntity<List<UserFamilyInfo>> httpEntity=new HttpEntity<List<UserFamilyInfo>>(list);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/insertUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testUpdateUserFamilyInfo() throws Exception {
    	
    	RestTemplate restTemplate = new RestTemplate();
		//参数
    	UserFamilyInfo userFamilyInfo=new UserFamilyInfo();
    	userFamilyInfo.setCredentialsNumber("22");
    	userFamilyInfo.setCredentialsType("22");
    	userFamilyInfo.setGender("女");
    	userFamilyInfo.setHighestEducation("22");
    	userFamilyInfo.setHighestEducationSchool("22");
    	userFamilyInfo.setEmail("22");
    	userFamilyInfo.setMailingAddress("22");
    	userFamilyInfo.setName("22");
    	userFamilyInfo.setOrganization("22");
    	userFamilyInfo.setCellNo("22");
    	userFamilyInfo.setRelation("22");
    	userFamilyInfo.setUniqueId("5");
    	userFamilyInfo.setInternalCode("fff");
        
    	
        HttpEntity<UserFamilyInfo> httpEntity=new HttpEntity<UserFamilyInfo>(userFamilyInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/updateUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testDeleteUserFamilyInfo() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserFamilyHistoryInfo userFamilyHistoryInfo=new UserFamilyHistoryInfo();
    	userFamilyHistoryInfo.setUniqueId("5");
    	userFamilyHistoryInfo.setInternalCode("fff");
    	userFamilyHistoryInfo.setDeleteOperator("hehe");

        HttpEntity<UserFamilyHistoryInfo> httpEntity=new HttpEntity<UserFamilyHistoryInfo>(userFamilyHistoryInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/UserFamily/deleteUserFamily",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }

}
