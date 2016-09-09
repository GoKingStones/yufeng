//package com.yufeng.controller;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import com.alibaba.fastjson.JSON;
//import com.yufeng.entity.FastConsumerLoanOrder;
//import com.yufeng.entity.FastConsumerLoanOrderCommodity;
//import com.yufeng.entity.UserBankCardInfo;
//
///**
// * 快速消费品分期订单控制层测试类
// * @author dh
// */
//public class FastConsumerLoanOrderControllerTest {
//
//public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
//
//	@Test
//    public void testGetFastConsumerLoanOrder() throws Exception {
//        //参数
//    	String parameter="orderId=11";
//    	RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> resultModelResponseEntity = restTemplate
//        		.getForEntity(REST_SERVICE_URI + "/FastConsumerLoanOrder/getFastConsumerLoanOrder?"+parameter,String.class);
//
//        System.out.println(resultModelResponseEntity.getBody());
//    }
//
//	@Test
//	public void testInsertFastConsumerLoanOrder() throws Exception {
//	    //参数
//	    RestTemplate restTemplate = new RestTemplate();
//        //订单
//	    FastConsumerLoanOrder f=new FastConsumerLoanOrder();
//	    f.setDiscountPrice(new BigDecimal(11));
//	    f.setInvoiceNumber("11");
//	    f.setOrderDiscountPrice(new BigDecimal(11));
//	    f.setOrderId("11");
//	    f.setOrderState("11");
//	    f.setOrderType("11");
//	    f.setTotalAmount(new BigDecimal(11));
//	    f.setUserInternalCode("11");
//	    //商品
//	    FastConsumerLoanOrderCommodity ff=new FastConsumerLoanOrderCommodity();
//	    ff.setAnonymous(false);
//	    ff.setCommodityId("11");
//	    ff.setCommodityName("11");
//	    ff.setDiscountPrice(new BigDecimal(11));
//	    ff.setExternalPayNumber("11");
//	    ff.setFinishTime(new Date());
//	    ff.setInformationState("11");
//	    ff.setNumber(11);
//	    ff.setOrderTime(new Date());
//	    ff.setPayCode("11");
//	    ff.setPayMessage("11");
//	    ff.setPayMethod("11");
//	    ff.setPayName("11");
//	    ff.setPayTime(new Date());
//	    ff.setPrice(new BigDecimal(11));
//	    ff.setReceiptTime(new Date());
//	    ff.setSellerInternalCode("11");
//	    ff.setSendTime(new Date());
//	    ff.setTotalAmount(new BigDecimal(11));
//	    ff.setUserInternalCode("11");
//
//	    List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
//	    list.add(ff);
//	    Map<String,Object> map=new HashMap<String,Object>();
//	    map.put("loanOrder",f);
//	    map.put("loanOrderConsumerList",list);
//	    String json=JSON.toJSONString(map);
//	    System.out.println(json);
//
//	    HttpEntity<String> httpEntity=new HttpEntity<String>(json);
//	    ResponseEntity<String> resultModelResponseEntity = restTemplate.
//	        exchange(REST_SERVICE_URI + "/FastConsumerLoanOrder/insertFastConsumerLoanOrder",HttpMethod.POST,httpEntity,String.class);
//
//	    System.out.println(resultModelResponseEntity.getBody());
//	}
//
//	@Test
//	public void testUpdateFastConsumerLoanOrder() throws Exception {
//	    //参数
//	    RestTemplate restTemplate = new RestTemplate();
//        //订单
//	    FastConsumerLoanOrder f=new FastConsumerLoanOrder();
//	    f.setDiscountPrice(new BigDecimal(22));
//	    f.setInvoiceNumber("22");
//	    f.setOrderDiscountPrice(new BigDecimal(22));
//	    f.setOrderId("22");
//	    f.setOrderState("22");
//	    f.setOrderType("22");
//	    f.setTotalAmount(new BigDecimal(22));
//	    f.setUserInternalCode("22");
//	    f.setUniqueId("8ee102c6-be1f-4a81-97e7-c9f71b918fe9");
//	    //商品
//	    FastConsumerLoanOrderCommodity ff=new FastConsumerLoanOrderCommodity();
//	    ff.setAnonymous(true);
//	    ff.setCommodityId("22");
//	    ff.setCommodityName("22");
//	    ff.setDiscountPrice(new BigDecimal(22));
//	    ff.setExternalPayNumber("22");
//	    ff.setFinishTime(new Date());
//	    ff.setInformationState("22");
//	    ff.setNumber(22);
//	    ff.setOrderTime(new Date());
//	    ff.setPayCode("22");
//	    ff.setPayMessage("22");
//	    ff.setPayMethod("22");
//	    ff.setPayName("22");
//	    ff.setPayTime(new Date());
//	    ff.setPrice(new BigDecimal(22));
//	    ff.setReceiptTime(new Date());
//	    ff.setSellerInternalCode("22");
//	    ff.setSendTime(new Date());
//	    ff.setTotalAmount(new BigDecimal(22));
//	    ff.setUserInternalCode("22");
//	    ff.setUniqueId("d1185fa4-1828-4a69-9cdd-2d46a6d5e8b2");
//
//	    List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
//	    list.add(ff);
//	    Map<String,Object> map=new HashMap<String,Object>();
//	    map.put("loanOrder",f);
//	    map.put("loanOrderConsumerList",list);
//	    String json=JSON.toJSONString(map);
//	    System.out.println(json);
//
//	    HttpEntity<String> httpEntity=new HttpEntity<String>(json);
//	    ResponseEntity<String> resultModelResponseEntity = restTemplate.
//	        exchange(REST_SERVICE_URI + "/FastConsumerLoanOrder/updateFastConsumerLoanOrder",HttpMethod.POST,httpEntity,String.class);
//
//	    System.out.println(resultModelResponseEntity.getBody());
//	}
//
//
//}
