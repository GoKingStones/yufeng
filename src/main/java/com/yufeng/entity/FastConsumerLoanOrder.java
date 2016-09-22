package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dh
 * 快速消费品分期订单
 */
public class FastConsumerLoanOrder implements Serializable{
	
	/**
     */
    private static final long serialVersionUID = 8515072576768655683L;
    
    //private String uniqueId;
	//订单id
	private long orderId;
	//订单类型
	//private String orderType;
	//购买用户内码
	private String userInternalCode;
	//订单状态
	private String orderState;
	//发票号
	//private String invoiceNumber;
	//总金额
	private BigDecimal totalAmount;

    //分期数
    private int installCount;

    //分期类型
    private String installType;

	//折扣金额
	private BigDecimal discountAmount;

    //实付总金额
    private BigDecimal actualTotalAmount;

    //利息
    private BigDecimal interest;

    //运费
    private BigDecimal freight;

    //订单生成时间
    private Date submitTime;

    //订单取消时间
    private Date cancelTime;

    //发货时间
    private Date sendTime;

    //收货时间
    private Date receiptTime;

    //全部退货时间
    private Date returnOrderTime;
    //部分退货时间
    private Date returnCommodityTime;

	//订单折扣价
	//private BigDecimal orderDiscountPrice;
	//创建时间
	private Date createTime;
	//修改时间
	private Date modTime;

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getReturnOrderTime() {
        return returnOrderTime;
    }

    public void setReturnOrderTime(Date returnOrderTime) {
        this.returnOrderTime = returnOrderTime;
    }

    public Date getReturnCommodityTime() {
        return returnCommodityTime;
    }

    public void setReturnCommodityTime(Date returnCommodityTime) {
        this.returnCommodityTime = returnCommodityTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getUserInternalCode() {
        return userInternalCode;
    }

    public void setUserInternalCode(String userInternalCode) {
        this.userInternalCode = userInternalCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getInstallCount() {
        return installCount;
    }

    public void setInstallCount(int installCount) {
        this.installCount = installCount;
    }

    public String getInstallType() {
        return installType;
    }

    public void setInstallType(String installType) {
        this.installType = installType;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getActualTotalAmount() {
        return actualTotalAmount;
    }

    public void setActualTotalAmount(BigDecimal actualTotalAmount) {
        this.actualTotalAmount = actualTotalAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
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
}
