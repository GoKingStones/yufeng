package com.yufeng.service.impl;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.algorithm.Base64Util;
import com.yufeng.entity.ChinaUnionPayRequest;
import com.yufeng.service.ChinaUnionPayService;
import com.yufeng.util.Utils;

import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.x509.certificate.X509Cert;
import cfca.sadk.util.Signature;


/**
 * Created by fishyu on 16/9/20.
 */
public class ChinaUnionPayServiceImpl implements ChinaUnionPayService {

	
	
	/**交易查询
	 * 
	 * 
	 * */
	public String queryPay(String orderId,String enterpriseNo,String merId,String txnTime) throws Exception{
		
		Map<String, String> resmap = new HashMap<String, String>();
		resmap.put("orderId", orderId);
		resmap.put("enterpriseNo", enterpriseNo);
		resmap.put("merId", merId);
		resmap.put("txnTime", txnTime);
		resmap.put("version", "1.0");
		resmap.put("txnType", "00");
		resmap.put("signMethod", "01");
		
		payMethod(resmap);
		
		return null;
	}
	
	
	/**余额查询
	 * @throws Exception 
	 * 
	 * 
	 * */
	public String queryBalance(String enterpriseNo,String merId,String settType) throws Exception{

		Map<String, String> resmap = new HashMap<String, String>();

		resmap.put("enterpriseNo", enterpriseNo);
		resmap.put("merId", merId);
		resmap.put("version", "1.0");
		resmap.put("txnType", "01");
		resmap.put("signMethod", "01");
		resmap.put("settType", settType);
		
		payMethod(resmap);
		
		return null;
		
	}

	
	
	/**交易申请
	 * @throws Exception 
	 * 
	 * 
	 * 
	 * */
	public String requestPay(ChinaUnionPayRequest chinaUnionPayRequest) throws Exception{
		
		
		Map<String, String> resmap = new HashMap<String, String>();
		resmap.put("orderId", chinaUnionPayRequest.getOrderId());
		resmap.put("txnAmt", chinaUnionPayRequest.getTxnAmt());
		resmap.put("enterpriseNo", chinaUnionPayRequest.getEnterpriseNo());
		resmap.put("merId", chinaUnionPayRequest.getMerId());
		resmap.put("accNo", chinaUnionPayRequest.getAccNo());
		resmap.put("backUrl", chinaUnionPayRequest.getBackUrl());
		resmap.put("BankName", chinaUnionPayRequest.getBankName());
		resmap.put("payName", chinaUnionPayRequest.getPayName());
		resmap.put("settType", chinaUnionPayRequest.getSettType());
		resmap.put("oldMerid", chinaUnionPayRequest.getOldMerid());
		resmap.put("bankNo", chinaUnionPayRequest.getBankNo());
		resmap.put("phone", chinaUnionPayRequest.getPhone());
		resmap.put("note", chinaUnionPayRequest.getNote());	
		
		resmap.put("version", "1.0");
		resmap.put("txnType", "12");
		resmap.put("signMethod", "01");
		resmap.put("ppType", "0");
		
		Date nowTime=new Date();
		SimpleDateFormat time=new SimpleDateFormat("YYYYMMddHHmmss");
		resmap.put("txnTime", time.format(nowTime));
		
		
		payMethod(resmap);
		
		return null;
	}


	/**代付方法
	 * @throws Exception 
	 * 
	 * 
	 * */
	public String payMethod(Map<String, String> resmap) throws Exception {

		Signature engine = new Signature();
		
		PrivateKey priKey;
		X509Cert cert = null;
		X509Cert[] certs = null;
		// 验签证书
		final String cmbcCertPath = System.getProperty("user.dir")+"/src/main/thirdpartylib/test1024.cer";
		// 消息签名
		final String sm2Path = System.getProperty("user.dir")+"/src/main/thirdpartylib/test1024.pfx";
		// 签名密码
		final String sm2Pass = "123123";
		priKey = KeyUtil.getPrivateKeyFromPFX(sm2Path, sm2Pass);
		cert = new X509Cert(new FileInputStream(cmbcCertPath));
		//使用私钥也能验签
		//cert = CertUtil.getCertFromPFX(sm2Path, sm2Pass);
		//certs = new X509Cert[] { cert };
		final String deviceType = JCrypto.JSOFT_LIB;
		JCrypto.getInstance().initialize(deviceType, null);
		final Session session = JCrypto.getInstance().openSession(deviceType);
		byte[] sourceData = signData(resmap).toString().getBytes("UTF8");
		// 加密串
		byte[] signature = engine.p1SignMessage(Mechanism.SHA1_RSA, sourceData,priKey, session);
		// 消息签名
		resmap.put("signature", Base64Util.encode(new String(signature)));
		String asd = connServer(resmap);
		Map<String, String> map = JSON.parseObject(asd, Map.class);
		// 消息验签
		boolean ooo = engine.p1VerifyMessage(Mechanism.SHA1_RSA, signData(map).toString().getBytes("UTF8"),Base64Util.decode(map.get("signature")).getBytes("UTF8"),
		cert.getPublicKey(), session);
		System.out.println("消息验签:" + ooo);
		return null;
	}
	
	
	public static Map<String, String> signData(Map<String, ?> contentData) {
		Map<String, String> submitFromData = new TreeMap<String, String>();
		Object[] key_arr = contentData.keySet().toArray();
		Arrays.sort(key_arr);
		for (Object key : key_arr) {
			Object value = contentData.get(key);
			if (value != null && StringUtils.isNotBlank(value.toString())) {
				if (!key.equals("signature")) {
					submitFromData.put(key.toString().trim(), value.toString()
							.trim());
				}
			}
		}
		return submitFromData;
	}

	public String connServer(Map<String, String> map) {

		String respXml = "";
		// 1.建立客户端socket连接，指定服务器位置及端口
		Socket socket = null;
		// 2.得到socket读写流
		OutputStream os = null;
		PrintWriter pw = null;
		// 输入流
		InputStream is = null;
		BufferedReader br = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(Utils.CHINAUNIONPAY_PAY_IP, Utils.CHINAUNIONPAY_PAY_PORT),1000);// 连接超时设置
			socket.setSoTimeout(5000); // 读写超时设置
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			is = socket.getInputStream();

			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// 3.利用流按照一定的操作，对socket进行读写操作
			String info = jsonObject(map);
			pw.write(info);
			pw.flush();
			socket.shutdownOutput();
			// 接收服务器的相应
			String reply = null;
			while (!((reply = br.readLine()) == null)) {
				respXml += reply;
			}
			System.out.println("接到返回：\n" + respXml);
			socket.shutdownInput();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.关闭资源
				if (br != null) {
					br.close();
				}
				if (is != null) {
					is.close();
				}
				if (pw != null) {
					pw.close();
				}
				if (os != null) {
					os.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
			}
		}
		return respXml;
	}
	/**
	 * ********************************************************
	 * 
	 * @Title: jsonObject
	 * @Description:将对象转换成json字符串
	 * @param obj
	 * @return String
	 * @date 2013-12-12 上午11:11:20
	 ******************************************************** 
	 */
	protected static String jsonObject(Object obj) {

		String json = "";
		try {
			json = JSONObject.toJSONString(obj);
			return json;
		} catch (Exception e) {
			json = "{\"err\":\"" + "JsonObject is wrong" + "\"}";
			return json;
		}
	}
   
	
	public static void main(String[] args) throws Exception{
		
		ChinaUnionPayRequest chinaUnionPayRequest = new ChinaUnionPayRequest();
		
		chinaUnionPayRequest.setOrderId("100263336649520");
		chinaUnionPayRequest.setTxnAmt("100");
		chinaUnionPayRequest.setEnterpriseNo("11001");
		chinaUnionPayRequest.setNote("test");
		chinaUnionPayRequest.setMerId("777290058111103");
		chinaUnionPayRequest.setAccNo("6216261000000000018");
		chinaUnionPayRequest.setBackUrl("192.168.2.168:8888");
		chinaUnionPayRequest.setBankName("平安银行");
		chinaUnionPayRequest.setPayName("全渠道");
		chinaUnionPayRequest.setSettType("1");
		chinaUnionPayRequest.setOldMerid("123456789");
		
		ChinaUnionPayServiceImpl chinaUnionPayServiceImpl = new ChinaUnionPayServiceImpl();
		chinaUnionPayServiceImpl.requestPay(chinaUnionPayRequest);
		
	}
	
	
	
	
	
}
