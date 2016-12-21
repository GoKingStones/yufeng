package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/12/21.
 * 中银消费订单退货
 */
public class BOCReturnOrderEntity {

    private String user_internal_code; //'购买用户内码',
    private String acctNo;	//中银消费金融账号	X(13)
    private String merchantCode;	//	(清算機構)商户代号	X(15)
    private BigDecimal returnAmt;	//	退货金额	9(8)V9(2)
    private String oriMerchantOrderId;	//	原消费交易订单号码	X(32)
    private Date oriPayTime;	//	原消費交易时间	9(14)
    private String merchantOrderId;	//	退貨交易订单号码	X(32)
    private String payGateOrderId;	//	中银退貨交易订单号码	X(32)
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    public String getUser_internal_code() {
        return user_internal_code;
    }

    public void setUser_internal_code(String user_internal_code) {
        this.user_internal_code = user_internal_code;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public BigDecimal getReturnAmt() {
        return returnAmt;
    }

    public void setReturnAmt(BigDecimal returnAmt) {
        this.returnAmt = returnAmt;
    }

    public String getOriMerchantOrderId() {
        return oriMerchantOrderId;
    }

    public void setOriMerchantOrderId(String oriMerchantOrderId) {
        this.oriMerchantOrderId = oriMerchantOrderId;
    }

    public Date getOriPayTime() {
        return oriPayTime;
    }

    public void setOriPayTime(Date oriPayTime) {
        this.oriPayTime = oriPayTime;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getPayGateOrderId() {
        return payGateOrderId;
    }

    public void setPayGateOrderId(String payGateOrderId) {
        this.payGateOrderId = payGateOrderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    @Override
    public String toString() {
        return "BOCReturnOrderEntity{" +
                "user_internal_code='" + user_internal_code + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", returnAmt=" + returnAmt +
                ", oriMerchantOrderId='" + oriMerchantOrderId + '\'' +
                ", oriPayTime=" + oriPayTime +
                ", merchantOrderId='" + merchantOrderId + '\'' +
                ", payGateOrderId='" + payGateOrderId + '\'' +
                ", createTime=" + createTime +
                ", modTime=" + modTime +
                '}';
    }
}
