package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kingstones on 16/7/16.
 *
 */
public class RegisterAccount implements Serializable{

    private String name;
    private String password;
    private String phoneNumber;
    //注册来源
    private String source;
    //账户状态
    private String accountFlag;
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString(){
        return name+","+password+","+phoneNumber+","
                +source+","+accountFlag+","+createTime;
    }
}
