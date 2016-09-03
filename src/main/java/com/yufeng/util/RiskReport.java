package com.yufeng.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class RiskReport {
	
	public static String partner_code;    
	public static String partner_key;
	public static String app_name;    
	
    static  {    
        Properties prop =  new  Properties();    
        InputStream in = Object. class .getResourceAsStream( "/tongdun.properties" );    
         try  {    
            prop.load(in);    
            partner_code = prop.getProperty( "partner_code" ).trim();    
            partner_key = prop.getProperty( "partner_key" ).trim(); 
            app_name = prop.getProperty( "app_name" ).trim(); 
        }  catch  (IOException e) {    
            e.printStackTrace();    
        }    
    }   
	
	 public static String sendGet(String id) {
		 String url="https://apitest.tongdun.cn/preloan/report/v6?partner_code=xypd&partner_key=f4b5bfc2ca6d42eb873d9c31f9e430cf&app_name=xypd_web&report_id="+id;
	        String result = "";
	        BufferedReader in = null;
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection connection = realUrl.openConnection();
	            // 设置通用的请求属性
	            connection.setRequestProperty("connection", "Keep-Alive");
	            // 建立实际的连接
	            connection.connect();
	            // 获取所有响应头字段
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 遍历所有的响应头字段
	            // 定义 BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输入流
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return result;
	    }
	 public static void main(String[] args) {
		 System.out.println(sendGet("ER2016090315095119811012"));
	}

}
