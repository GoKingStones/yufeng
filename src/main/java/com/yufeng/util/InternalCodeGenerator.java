package com.yufeng.util;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.yufeng.algorithm.Base64Util;

/**
 * Created by kingstones on 16/7/23.
 * 根据两标生成内码
 */
public class InternalCodeGenerator {

    /**
     * 生成身份证类型的内码，输入参数是身份证号
     * 0身份证，1驾驶证。。。
     * @param certificateNum
     * @return
     */
    public static String getCode(String certificateNum){

        return getCode(0,certificateNum);

    }

    public static String getCode(int certificateType,String certificateNum) {

        String result="";
        if(!certificateNum.equals("")) {
            try {
                result = Base64Util.encode(""+certificateType+certificateNum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    public static void main(String[] args) {

        String num="0392343589933X";
        System.out.println(InternalCodeGenerator.getCode(num));
        System.out.println(InternalCodeGenerator.getCode(num).length());


    }

}
