package com.yufeng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kingstones on 16/9/5.
 */
public class DateUtil {

    private static  Logger logger= LoggerFactory.getLogger(DateUtil.class);
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String dateToString(Date date) {

        String result ="";
        try {
            result = simpleDateFormat.format(date);
        }catch (Exception e) {
            logger.error(date+"cannot be format");
        }
        return result;

    }

    public static Date stringToDate(String date) {
        Date date1=null;
        try {
            date1=simpleDateFormat.parse(date);
        }catch (Exception e) {
            logger.error(date+"cannot be format");
        }
        return date1;
    }

    public static void main(String[] args) {
        Date date = DateUtil.stringToDate("2016-09-05 10:21:48");
        System.out.println(date.getDay());
    }
}
