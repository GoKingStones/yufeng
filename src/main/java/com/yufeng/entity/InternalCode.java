package com.yufeng.entity;

import java.util.Date;

/**
 * Created by kingstones on 16/7/24.
 * 内码类
 */
public class InternalCode {

    //ID
    private String internalCode;
    //创建时间
    private Date createTime;

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
