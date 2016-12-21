package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kingstones on 16/7/16.
 * 用户注册账号实体
 *
 */
public class RegisterAccount implements Serializable{


    private int registerAccountId;
    private String internalCode;
    private String accountName;
    private String password;
    private String phoneNumber;
    //注册来源
    private String source;
    //账户状态
    private String accountFlag;
    private Date createTime;
    private Date modTime;//修改时间


    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }



    public int getRegisterAccountId() {
        return registerAccountId;
    }

    public void setRegisterAccountId(int registerAccountId) {
        this.registerAccountId = registerAccountId;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountFlag() {
        return accountFlag;
    }

    public void setAccountFlag(String accountFlag) {
        this.accountFlag = accountFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "RegisterAccount{" +
                "registerAccountId=" + registerAccountId +
                ", internalCode='" + internalCode + '\'' +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", source='" + source + '\'' +
                ", accountFlag='" + accountFlag + '\'' +
                ", createTime=" + createTime +
                ", modTime=" + modTime +
                '}';
    }
}

