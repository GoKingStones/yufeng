package com.yufeng.controller;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.yufeng.entity.UserBankCardInfo;

/**
 * 银行卡控制层测试类
 * @author dh
 */
public class BankCardControllerTest {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	@Test
    public void testGetBankCardByCode() throws Exception {
        //参数
    	String parameter="code=xx";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/BankCard/getBankCardByCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	@Test
    public void testGetBankCardById() throws Exception {
		//参数
    	String parameter="id=7";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/BankCard/getBankCardByID?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testInsertBankCard() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserBankCardInfo userBankCardInfo=new UserBankCardInfo();
    	userBankCardInfo.setInternal_code("ni");
    	userBankCardInfo.setBankCardNumber("hehehe");
    	userBankCardInfo.setBankCardState("hehe");
    	userBankCardInfo.setDelete_operator("hehe");
    	userBankCardInfo.setBankCardState("hehe");
    	userBankCardInfo.setBankCardType("hehe");
    	userBankCardInfo.setExpireTime(new Date());
    	userBankCardInfo.setTransferAccount(true);

        HttpEntity<UserBankCardInfo> httpEntity=new HttpEntity<UserBankCardInfo>(userBankCardInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/BankCard/insertBankCard",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testUpdateBankCard() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserBankCardInfo userBankCardInfo=new UserBankCardInfo();
    	userBankCardInfo.setInternal_code("11");
    	userBankCardInfo.setBankCardNumber("11");
    	userBankCardInfo.setBankCardState("11");
    	userBankCardInfo.setDelete_operator("11");
    	userBankCardInfo.setBankCardState("11");
    	userBankCardInfo.setBankCardType("11");
    	userBankCardInfo.setExpireTime(new Date());
    	userBankCardInfo.setTransferAccount(false);
    	userBankCardInfo.setId("38");

        HttpEntity<UserBankCardInfo> httpEntity=new HttpEntity<UserBankCardInfo>(userBankCardInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/BankCard/updateBankCard",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testDeleteBankCard() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserBankCardInfo userBankCardInfo=new UserBankCardInfo();
    	userBankCardInfo.setId("38"); 
    	userBankCardInfo.setDelete_operator("hhh");

        HttpEntity<UserBankCardInfo> httpEntity=new HttpEntity<UserBankCardInfo>(userBankCardInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/BankCard/deleteBankCard",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
	

}
