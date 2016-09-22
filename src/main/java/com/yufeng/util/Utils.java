package com.yufeng.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;

public class Utils {
    
    

	
	//信用额度基础值
	public final static int BASIC_CREDIT_LINE = 5000;
	
	//信用额度最高值
	public final static int HIGHEST_CREDIT_LINE = 10000;
	
	//信用额度最低值
	public final static int BASE_CREDIT_LINE = 500;
	
	//基础学费
	public final static int BASIC_TUITION = 5000;
	
	//在校基础消费
	public final static int BASIC_CONSUMPTION_IN_SCHOOL = 5000;
	
	//担保圈人数
	public final static int TOTAL_GUARANTEE = 4;
	
	//用户等级-初级用户
	public final static int LEVEL_0 = 0;
	
	//用户等级-一级用户
	public final static int LEVEL_1 = 1;
	
	//用户等级-二级用户
	public final static int LEVEL_2 = 2;
		
	//用户等级-三级用户
	public final static int LEVEL_3 = 3;
	
	//用户等级-无级用户
	public final static int NO_LEVEL = -1;
	
	public final static String BJ_CODE = "110000";
	
	
	//学生账户
	public final static String STUDENT_ACCOUNT = "student";
	//成人账户
	public final static String ADULT_ACCOUNT = "adult";
	
	//信用账户状态--正常
	public final static String NORMAL_ACCOUNT = "normal";
	
	//信用账户状态--失效
	public final static String INVALID_ACCOUNT = "invalid";
	
	//信用账户状态--冻结
	public final static String FREEZE_ACCOUNT = "freeze";
	
	public final static BigDecimal GUARANTEE_QUOATA_RATIO = new BigDecimal(0.2);
	
	//风险评估参数
	public static String partner_code;    
    public static String partner_key;
    public static String app_name;    
    public static String submitRrl;
    public static String queryRrl;
    
    static{
        try {
            Properties prop =new Properties();
            prop.load(new InputStreamReader(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("/tongdun.properties"),"UTF-8"));
            partner_code = prop.getProperty( "partner_code" ).trim();    
            partner_key = prop.getProperty( "partner_key" ).trim(); 
            app_name = prop.getProperty( "app_name" ).trim(); 
            submitRrl = prop.getProperty( "submitRrl" ).trim();
            queryRrl = prop.getProperty( "queryRrl" ).trim(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //银联代付服务器连接IP
    public final static String CHINAUNIONPAY_PAY_IP = "211.103.172.38";
    //银联代付服务器连接IP端口
    public final static int CHINAUNIONPAY_PAY_PORT = 8830;
    
    
    //返回值代码
    public final static String RETURN_VALUE_CODE_0= "0";
    public final static String RETURN_VALUE_CODE_1= "1";
    public final static String RETURN_VALUE_CODE_2 = "2";
    public final static String RETURN_VALUE_CODE_3 = "3";
    public final static String RETURN_VALUE_CODE_99 = "99";
    
	/**
	 * 日期比较
	 * @param DATE1 
	 * @param DATE2
	 * @return 返回1 DATE1早于DATE2；返回-1 DATE1晚于DATE2；
	 * */
	 public static int compare_date(Date DATE1, Date DATE2) {
	       
	       
	        try {

	            if (DATE1.getTime() > DATE2.getTime()) {
	                System.out.println("dt1 在dt2前");
	                return 1;
	            } else if (DATE1.getTime() < DATE2.getTime()) {
	                System.out.println("dt1在dt2后");
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	
}
