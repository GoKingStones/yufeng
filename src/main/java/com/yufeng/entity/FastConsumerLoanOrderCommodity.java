package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author dh
 * 快速消费品分期订单商品
 */
public class FastConsumerLoanOrderCommodity implements Serializable{
	
	/**
     */
    private static final long serialVersionUID = -8767014670873500018L;
    
    //id
	private String uniqueId;
	//商品id
	private String commodityId;
	//商品名
	private String commodityName;
	//订单id
	private String orderId;
	//价格
	private BigDecimal price;
	//数量
	private Integer number;
	//购买用户内码
	private String userInternalCode;
	//商户内码
	private String sellerInternalCode;
	//总金额
	private BigDecimal totalAmount;
	//信息状态
	private String informationState;
	//支付方式
	private String payMethod;
	//支付名
	private String payName;
	//支付编码
	private String payCode;
	//外部支付号
	private String externalPayNumber;
	//支付时间
	private Date payTime;
	//下单时间
	private Date orderTime;
	//发货时间
	private Date sendTime;
	//支付信息
	private String payMessage;
	//收货时间
	private Date receiptTime;
	//完成时间
	private Date finishTime;
	//折扣价
	private BigDecimal discountPrice;
	//是否匿名
	private Boolean anonymous;
	//创建时间
    private Date createTime;
    //修改时间
    private Date modTime;
    
    public String getUniqueId() {
        return uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public String getCommodityId() {
        return commodityId;
    }
    
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    
    public String getCommodityName() {
        return commodityName;
    }
    
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
    public String getUserInternalCode() {
        return userInternalCode;
    }
    
    public void setUserInternalCode(String userInternalCode) {
        this.userInternalCode = userInternalCode;
    }
    
    public String getSellerInternalCode() {
        return sellerInternalCode;
    }
    
    public void setSellerInternalCode(String sellerInternalCode) {
        this.sellerInternalCode = sellerInternalCode;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getInformationState() {
        return informationState;
    }
    
    public void setInformationState(String informationState) {
        this.informationState = informationState;
    }
    
    public String getPayMethod() {
        return payMethod;
    }
    
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    
    public String getPayName() {
        return payName;
    }
    
    public void setPayName(String payName) {
        this.payName = payName;
    }
    
    public String getPayCode() {
        return payCode;
    }
    
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }
    
    public String getExternalPayNumber() {
        return externalPayNumber;
    }
    
    public void setExternalPayNumber(String externalPayNumber) {
        this.externalPayNumber = externalPayNumber;
    }
    
    public Date getPayTime() {
        return payTime;
    }
    
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    
    public Date getOrderTime() {
        return orderTime;
    }
    
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
    
    public Date getSendTime() {
        return sendTime;
    }
    
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    
    public String getPayMessage() {
        return payMessage;
    }
    
    public void setPayMessage(String payMessage) {
        this.payMessage = payMessage;
    }
    
    public Date getReceiptTime() {
        return receiptTime;
    }
    
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }
    
    public Date getFinishTime() {
        return finishTime;
    }
    
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
    
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
    
    public Boolean getAnonymous() {
        return anonymous;
    }
    
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
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
