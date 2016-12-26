package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/12/21.
 * 中银消费订单实体
 */
public class BOCLoanOrderEntity {
    
    private Integer id;
    private String userInternalCode; //'购买用户内码',
    private String loanAcctNo;	//中银消费金融账号	X(13)
    private String merchantCode;	//	(清算)商户代号	X(15)
    private BigDecimal amount;	//	消费金额	9(8)V9(2)	单位：分
    private String merchantOrderId;	//	消费交易訂单号	X(32)
    private String payGateOrderId;	//	中银消費(動用)交易订单号码	X(32)
    /**
     *  1：消费信用支付
     2：账户充值
     3：微现金"
     */
    private String payType;	//	消费支付类型	X(1)	"不能為空

    /**
     * 1：账户贷款充值
     9：退货溢出款充值"
     */
    private String chargeType;	//	账户充值类型		"0：无关

    private String currency;	//	币种	X(3)	不能為空
    /**
     *  N：无加额"
     */
    private String useTempCreLine;	//	是否同意加额？	X（1）	"Y：同意使用临时额度

    private String payDescription;	//	订单备注说明	X(100)	非必输項
    private int instalPeriod;	//	分期期数	9(3)	不能為空
    /**
     * 默认值： A"
     */
    private String instalType;	//	分期方案	X(1)	"不能為空，

    /**
     * 默认值： A"
     */
    private String instalFeeType;	//	分期手续费方案	X(1)	"不能為空，

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



    
    public String getPayType() {
        return payType;
    }



    
    public void setPayType(String payType) {
        this.payType = payType;
    }



    
    public String getChargeType() {
        return chargeType;
    }



    
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }



    
    public String getCurrency() {
        return currency;
    }



    
    public void setCurrency(String currency) {
        this.currency = currency;
    }



    
    public String getUseTempCreLine() {
        return useTempCreLine;
    }



    
    public void setUseTempCreLine(String useTempCreLine) {
        this.useTempCreLine = useTempCreLine;
    }



    
    public String getPayDescription() {
        return payDescription;
    }



    
    public void setPayDescription(String payDescription) {
        this.payDescription = payDescription;
    }



    
    public int getInstalPeriod() {
        return instalPeriod;
    }



    
    public void setInstalPeriod(int instalPeriod) {
        this.instalPeriod = instalPeriod;
    }



    
    public String getInstalType() {
        return instalType;
    }



    
    public void setInstalType(String instalType) {
        this.instalType = instalType;
    }



    
    public String getInstalFeeType() {
        return instalFeeType;
    }



    
    public void setInstalFeeType(String instalFeeType) {
        this.instalFeeType = instalFeeType;
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
        return "BOCLoanOrderEntity{" +
                "userInternalCode='" + userInternalCode + '\'' +
                ", loanAcctNo='" + loanAcctNo + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", amount=" + amount +
                ", merchantOrderId='" + merchantOrderId + '\'' +
                ", payGateOrderId='" + payGateOrderId + '\'' +
                ", payType='" + payType + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", currency='" + currency + '\'' +
                ", useTempCreLine='" + useTempCreLine + '\'' +
                ", payDescription='" + payDescription + '\'' +
                ", instalPeriod=" + instalPeriod +
                ", instalType='" + instalType + '\'' +
                ", instalFeeType='" + instalFeeType + '\'' +
                ", createTime=" + createTime +
                ", modTime=" + modTime +
                '}';
    }
}
