package com.yufeng.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
