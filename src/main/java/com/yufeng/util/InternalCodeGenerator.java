package com.yufeng.util;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.yufeng.algorithm.Base64Util;
import com.yufeng.algorithm.IDCard;
import com.yufeng.algorithm.MD5Util;

import java.util.Map;

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
        IDCard idCard=new IDCard();

        if(certificateType==0) {
            if(!certificateNum.equals("")&&idCard.IDCardValidate(certificateNum).equals("")) {
                try {
                    String s = certificateNum.substring(0,certificateNum.length()-1);
                    char y = certificateNum.charAt(17);
                    long d = Long.parseLong(s)*8;
                    result = Base64Util.encode(""+certificateType+String.valueOf(d)+String.valueOf(y));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;

    }

    /**
     * 解码身份证证件类型
     * @param code
     * @return 数组第一个元素是证件类型，第二个为证件号码
     */
    public static Object[] decode(String code ) {

        Object[] objects=null;
        try {
            String decode=Base64Util.decode(code);
            objects = new Object[2];

            if(String.valueOf(decode.charAt(0)).equals("0")){
                objects[0]=decode.charAt(0);
                objects[1] =(""+Long.parseLong(decode.substring(1, decode.length() - 1))/8)+decode.charAt(decode.length()-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objects;


    }

    public static void main(String[] args) {

        String num="15263319620423002x";
        String code=InternalCodeGenerator.getCode(num);
        Object[] result=InternalCodeGenerator.decode(code);
        System.out.println(result[0]+"    "+result[1]);

    }

}
