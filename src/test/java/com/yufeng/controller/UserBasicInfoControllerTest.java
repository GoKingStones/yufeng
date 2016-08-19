package com.yufeng.controller;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.util.ResultModel;
import com.yufeng.util.Utils;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by kingstones on 16/8/10.
 */
public class UserBasicInfoControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";

  

    @Test
    public void testInsertRegisterAccount() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        //更新注册账户的内码，保存客户基本信息，生成信用账户
      	UserBasicInfo userBasicInfo = new UserBasicInfo();	
      	userBasicInfo.setName("于祺康");
      	userBasicInfo.setIdType("0");
      	userBasicInfo.setIdNo("120104198408175117");
      	userBasicInfo.setCellNo("18601923137");
      	userBasicInfo.setEmail("81741099@qq.com");
      	userBasicInfo.setFamilyAddress("天津市家庭地址");
      	userBasicInfo.setMaritalStatus("已婚");
      	userBasicInfo.setPostalAddress("天津市邮寄地址");
      	userBasicInfo.setIdcardFrontImgUrl("/user/zhengmian");
      	userBasicInfo.setIdcardBackImgUrl("/user/fanmian");
      	userBasicInfo.setWeixinNo("yuqikang");
      	userBasicInfo.setWeiboNo("weibo");
      	userBasicInfo.setQqNo("81741099");
      	userBasicInfo.setAddress("天津市现住址");
      	
      	Map<String,Object> map=new HashMap<String,Object>();
      	map.put("accountType",Utils.STUDENT_ACCOUNT);
      	map.put("userBasicInfo",userBasicInfo);
      	
      	String json=JSON.toJSONString(map);
	    System.out.println(json);

        HttpEntity<String> httpEntity=new HttpEntity<String>(json);
        ResponseEntity<ResultModel> resultModelResponseEntity = restTemplate.exchange(REST_SERVICE_URI + "/userBasicInfo/insertUserBasicInfoForSignUp",
                HttpMethod.POST,
                httpEntity,
                ResultModel.class);

        System.out.println(resultModelResponseEntity.getStatusCode());
        System.out.println(resultModelResponseEntity.getBody().getCode());
        System.out.println(resultModelResponseEntity.getBody().getContent());
        System.out.println(resultModelResponseEntity.getBody().getMessage());
        

        
    }

  
}
