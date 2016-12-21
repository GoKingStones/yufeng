package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/12/21.
 * 中银消费明细
 */
public class BOCLoanDetail {

    private String user_internal_code; //'购买用户内码',
    private String seller_internal_code; //'商户内码',
    private Date purDate;	//消费日期	9(8)
    private Date purTime;	//	消费时间	9(6)
    private BigDecimal payAmt;	//	消费金额(本金)	9(8)V9(2)
    private BigDecimal remainAmt;	//	剩余未还金额(本金)	9(8)V9(2)
    private BigDecimal returnAmt;	//	退货累计金额	9(8)V9(2)
    private String merchantCode;	//	(清算)商户代号	X(15)
    private String merchantOrderId;	//	動用交易订单号码	X(32)
    private String payGateOrderId;	//	中银動用交易订单号码	X(32)
    private String payDescription;	//	消费交易備註说明	X(100)
    private Date instalStDate;	//	分期起日	X(8)
    private Date instalEdDate;	//	分期迄日	X(8)
    private int instalPeriod;	//	(原)分期期数	9(3)
    private int remainPeriod;	//	剩余期数	9(3)
    private BigDecimal insFeeTot;	//	分期手续费	9(8)V9(2)
    private BigDecimal intTot;	//	利息	9(8)V9(2)
    private BigDecimal othenFee;	//	其他费用	9(8)V9(2)
    private BigDecimal payOffAmt;	//	单笔结清还款金额	9(8)V9(2)
    private int realPayPeriod;	//	实际应缴未繳的總期数	9(3)
    private int currPayPeriod;	//	当前应缴的期数	9(3)
    private int realInstalPeriod;	//	实际分期期数	9(3)
    private BigDecimal unpayAmt;	//	当期以前剩餘應償還金額	9(8)V9(2)
    private String unpayFlag;	//	逾期未偿还标记	X(1)
    private String detailFlag;	//	查询明细标记	X(1)
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    public String getUser_internal_code() {
        return user_internal_code;
    }

    public void setUser_internal_code(String user_internal_code) {
        this.user_internal_code = user_internal_code;
    }

    public String getSeller_internal_code() {
        return seller_internal_code;
    }

    public void setSeller_internal_code(String seller_internal_code) {
        this.seller_internal_code = seller_internal_code;
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

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public Date getPurTime() {
        return purTime;
    }

    public void setPurTime(Date purTime) {
        this.purTime = purTime;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public BigDecimal getRemainAmt() {
        return remainAmt;
    }

    public void setRemainAmt(BigDecimal remainAmt) {
        this.remainAmt = remainAmt;
    }

    public BigDecimal getReturnAmt() {
        return returnAmt;
    }

    public void setReturnAmt(BigDecimal returnAmt) {
        this.returnAmt = returnAmt;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
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

    public String getPayDescription() {
        return payDescription;
    }

    public void setPayDescription(String payDescription) {
        this.payDescription = payDescription;
    }

    public Date getInstalStDate() {
        return instalStDate;
    }

    public void setInstalStDate(Date instalStDate) {
        this.instalStDate = instalStDate;
    }

    public Date getInstalEdDate() {
        return instalEdDate;
    }

    public void setInstalEdDate(Date instalEdDate) {
        this.instalEdDate = instalEdDate;
    }

    public int getInstalPeriod() {
        return instalPeriod;
    }

    public void setInstalPeriod(int instalPeriod) {
        this.instalPeriod = instalPeriod;
    }

    public int getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(int remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getInsFeeTot() {
        return insFeeTot;
    }

    public void setInsFeeTot(BigDecimal insFeeTot) {
        this.insFeeTot = insFeeTot;
    }

    public BigDecimal getIntTot() {
        return intTot;
    }

    public void setIntTot(BigDecimal intTot) {
        this.intTot = intTot;
    }

    public BigDecimal getOthenFee() {
        return othenFee;
    }

    public void setOthenFee(BigDecimal othenFee) {
        this.othenFee = othenFee;
    }

    public BigDecimal getPayOffAmt() {
        return payOffAmt;
    }

    public void setPayOffAmt(BigDecimal payOffAmt) {
        this.payOffAmt = payOffAmt;
    }

    public int getRealPayPeriod() {
        return realPayPeriod;
    }

    public void setRealPayPeriod(int realPayPeriod) {
        this.realPayPeriod = realPayPeriod;
    }

    public int getCurrPayPeriod() {
        return currPayPeriod;
    }

    public void setCurrPayPeriod(int currPayPeriod) {
        this.currPayPeriod = currPayPeriod;
    }

    public int getRealInstalPeriod() {
        return realInstalPeriod;
    }

    public void setRealInstalPeriod(int realInstalPeriod) {
        this.realInstalPeriod = realInstalPeriod;
    }

    public BigDecimal getUnpayAmt() {
        return unpayAmt;
    }

    public void setUnpayAmt(BigDecimal unpayAmt) {
        this.unpayAmt = unpayAmt;
    }

    public String getUnpayFlag() {
        return unpayFlag;
    }

    public void setUnpayFlag(String unpayFlag) {
        this.unpayFlag = unpayFlag;
    }

    public String getDetailFlag() {
        return detailFlag;
    }

    public void setDetailFlag(String detailFlag) {
        this.detailFlag = detailFlag;
    }

    @Override
    public String toString() {
        return "BOCLoanDetail{" +
                "purDate=" + purDate +
                ", purTime=" + purTime +
                ", payAmt=" + payAmt +
                ", remainAmt=" + remainAmt +
                ", returnAmt=" + returnAmt +
                ", merchantCode='" + merchantCode + '\'' +
                ", merchantOrderId='" + merchantOrderId + '\'' +
                ", payGateOrderId='" + payGateOrderId + '\'' +
                ", payDescription='" + payDescription + '\'' +
                ", instalStDate=" + instalStDate +
                ", instalEdDate=" + instalEdDate +
                ", instalPeriod=" + instalPeriod +
                ", remainPeriod=" + remainPeriod +
                ", insFeeTot=" + insFeeTot +
                ", intTot=" + intTot +
                ", othenFee=" + othenFee +
                ", payOffAmt=" + payOffAmt +
                ", realPayPeriod=" + realPayPeriod +
                ", currPayPeriod=" + currPayPeriod +
                ", realInstalPeriod=" + realInstalPeriod +
                ", unpayAmt=" + unpayAmt +
                ", unpayFlag='" + unpayFlag + '\'' +
                ", detailFlag='" + detailFlag + '\'' +
                '}';
    }
}
