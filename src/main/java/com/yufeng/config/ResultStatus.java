package com.yufeng.config;

/**
 * 自定义请求状态码
 * kingstones
 */

public enum ResultStatus {


    SUCCESS(100, "成功"),
    USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
    USER_NOT_FOUND(-1002, "用户不存在"),
    ALREADY_EXISTED(-1003,"已存在"),
    BAD_REQUEST(-100, "传入参数异常"),
    OPERATION_FAILURE(-200,"操作失败"),
    INTERNAL_SERVER_ERROR(-101, "后台异常"),
    USER_NOT_LOGIN(-1003, "用户未登录"),
   
    //银行卡请求码
    BANKCARDNUMBER_REPEAT(-1101, "银行卡号码重复"),
    BANKCARD_NOT_FOUND(-1102, "不存在此银行卡"),
	
    //家属联系人请求码
    CREDENTIALSNUMBER_REPEAT(-1201, "证件卡号码重复"),
    FAMILY_NOT_FOUND(-1202, "不存在此联系人信息"),
    
    //用户金融账户信息请求码
    FINANCIALCONSUMEACCOUNTID_REPEAT(-1301, "金融账户重复"),
    FINANCIALACCOUNT_NOT_FOUND(-1302, "不存在金融账户信息");
    

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
