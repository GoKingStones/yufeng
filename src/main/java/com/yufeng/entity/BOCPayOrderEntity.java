package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/12/21.
 * 中银消费还款实体
 */
public class BOCPayOrderEntity {

    private Integer id;
    private String userInternalCode; //'购买用户内码',
    private String loanAcctNo;	//中银消费金融账号	X(13)	不可為空
    private String merchantCode;	//	清算機構(商戶)代號	X(15)	不能為空
    private BigDecimal amount;	//	还款金额	9(8)V9(2)	不可為空
    private Date returnDate;	//	还款日期	X(8)	"YYYYMMDD

    private String merchantOrderId;	//	还款交易订单号	X(32)	不可為空
    private String oriPayGateOrderId;	//	原中银消费(動用)交易订单号码	X(32)	必需有值
    private String payGateOrderId;	//	中银還款交易订单号码	X(32)
    private Date oriPayTime	;	//原消費交易之交易时间	9(14)	必需有值
    /**
     *  1：還當期欠款
     2：還當筆欠款"
     */
    private String returnType;	//	還款類別	X(1)	"必需有值

    /**
     *  26：内部转账
     27：指定还款
     30：逾期扣款
     32：网络还款
     33：退还金额还款
     34：自动还款
     39：核销呆账"
     */
    private String payType;	//还款类别	X(2)	"20：主动还款

    private String debitCardNo;	//	借记卡卡号	X(20)	不可為空
    private String decardOpenBank;	//	借记卡开户銀行名称	X(50)	不可為空
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    

    
    public Integer getId() {
        return id;
    }



    
    public void setId(Integer id) {
        this.id = id;
    }



    
    public String getUserInternalCode() {
        return userInternalCode;
    }



    
    public void setUserInternalCode(String userInternalCode) {
        this.userInternalCode = userInternalCode;
    }



    
    public String getLoanAcctNo() {
        return loanAcctNo;
    }



    
    public void setLoanAcctNo(String loanAcctNo) {
        this.loanAcctNo = loanAcctNo;
    }



    
    public String getMerchantCode() {
        return merchantCode;
    }



    
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }



    
    public BigDecimal getAmount() {
        return amount;
    }



    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



    
    public Date getReturnDate() {
        return returnDate;
    }



    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }



    
    public String getMerchantOrderId() {
        return merchantOrderId;
    }



    
    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }



    
    public String getOriPayGateOrderId() {
        return oriPayGateOrderId;
    }



    
    public void setOriPayGateOrderId(String oriPayGateOrderId) {
        this.oriPayGateOrderId = oriPayGateOrderId;
    }



    
    public String getPayGateOrderId() {
        return payGateOrderId;
    }



    
    public void setPayGateOrderId(String payGateOrderId) {
        this.payGateOrderId = payGateOrderId;
    }



    
    public Date getOriPayTime() {
        return oriPayTime;
    }



    
    public void setOriPayTime(Date oriPayTime) {
        this.oriPayTime = oriPayTime;
    }



    
    public String getReturnType() {
        return returnType;
    }



    
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }



    
    public String getPayType() {
        return payType;
    }



    
    public void setPayType(String payType) {
        this.payType = payType;
    }



    
    public String getDebitCardNo() {
        return debitCardNo;
    }



    
    public void setDebitCardNo(String debitCardNo) {
        this.debitCardNo = debitCardNo;
    }



    
    public String getDecardOpenBank() {
        return decardOpenBank;
    }



    
    public void setDecardOpenBank(String decardOpenBank) {
        this.decardOpenBank = decardOpenBank;
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
        return "BOCPayOrderEntity{" +
                "userInternalCode='" + userInternalCode + '\'' +
                ", loanAcctNo='" + loanAcctNo + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", amount=" + amount +
                ", returnDate=" + returnDate +
                ", merchantOrderId='" + merchantOrderId + '\'' +
                ", oriPayGateOrderId='" + oriPayGateOrderId + '\'' +
                ", payGateOrderId='" + payGateOrderId + '\'' +
                ", oriPayTime=" + oriPayTime +
                ", returnType='" + returnType + '\'' +
                ", debitCardNo='" + debitCardNo + '\'' +
                ", decardOpenBank='" + decardOpenBank + '\'' +
                ", createTime=" + createTime +
                ", modTime=" + modTime +
                '}';
    }
}
