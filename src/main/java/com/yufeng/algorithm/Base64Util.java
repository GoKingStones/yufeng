package com.yufeng.algorithm;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * Created by kingstones on 16/7/20.
 */
public class Base64Util {
    public static String encode(String code) throws UnsupportedEncodingException, Exception {
        return encodeBase64(code.getBytes("utf-8"));
    }

    public static String decode(String code) throws UnsupportedEncodingException, Exception {
        return new String(decodeBase64(code),"utf-8");
    }

    public static String encodeBase64(byte[] input) throws Exception {
        Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("encode", byte[].class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke(null, new Object[] { input });
        return (String) retObj;
    }

    public static byte[] decodeBase64(String input) throws Exception {
        Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke(null, input);
        return (byte[]) retObj;
    }

    public static void main(String[] rags) throws UnsupportedEncodingException, Exception {
        String str = "王磊磊150125198912025318";
        //"546L56OKMTUwMTI1MTk4OTEyMDI1MzE4";
        //546L56OK56OKMTUwMTI1MTk4OTEyMDI1MzE4
        String code = Base64Util.encode(str);
        System.err.println("加密前：" + str);
        System.err.println("加密后：" + code);
        System.out.println(code.length());
        System.err.println("解密后：" + Base64Util.decode(code));

    }

}

