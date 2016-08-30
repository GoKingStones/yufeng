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

/**
 * 银行卡控制层测试类
 * @author dh
 */
public class BankCardControllerTest {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	//@Test
    public void testGetBankCardByCode() throws Exception {
        //参数
    	String parameter="internalCode=xx";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/BankCard/getBankCardByInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	//@Test
    public void testGetBankCardById() throws Exception {
		//参数
    	String parameter="uniqueId=7&internalCode=zz";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/BankCard/getBankCardByIdAndInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testInsertBankCard() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserBankCardInfo userBankCardInfo=new UserBankCardInfo();
    	userBankCardInfo.setInternalCode("11");
    	userBankCardInfo.setBankCardNumber("2223");
    	userBankCardInfo.setBankCardState("11");
    	userBankCardInfo.setBankCardState("11");
    	userBankCardInfo.setBankCardType("11");
    	userBankCardInfo.setExpireTime(new Date());
    	userBankCardInfo.setTransferAccount(true);
    	List<UserBankCardInfo> list=new ArrayList<UserBankCardInfo>();
        list.add(userBankCardInfo);
        HttpEntity<List<UserBankCardInfo>> httpEntity=new HttpEntity<List<UserBankCardInfo>>(list);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/BankCard/insertBankCard",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testUpdateBankCard() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	UserBankCardInfo userBankCardInfo=new UserBankCardInfo();
    	userBankCardInfo.setInternalCode("11");
    	userBankCardInfo.setBankCardNumber("11");
    	userBankCardInfo.setBankCardState("12");
    	userBankCardInfo.setBankCardType("12");
    	userBankCardInfo.setExpireTime(new Date());
    	userBankCardInfo.setTransferAccount(false);
    	userBankCardInfo.setUniqueId("40");

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
    	userBankCardInfo.setUniqueId("40"); 
    	userBankCardInfo.setDeleteOperator("hhh");
    	userBankCardInfo.setInternalCode("11");

        HttpEntity<UserBankCardInfo> httpEntity=new HttpEntity<UserBankCardInfo>(userBankCardInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/BankCard/deleteBankCard",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
	

}
