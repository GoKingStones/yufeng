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
    
    private String uniqueId;
	//订单id
	private String orderId;
	//订单类型
	private String orderType;
	//购买用户内码
	private String userInternalCode;
	//订单状态
	private String orderState;
	//发票号
	private String invoiceNumber;
	//总金额
	private BigDecimal totalAmount;
	//折扣价
	private BigDecimal discountPrice;
	//订单折扣价
	private BigDecimal orderDiscountPrice;
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
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderType() {
        return orderType;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
    
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
    
    public BigDecimal getOrderDiscountPrice() {
        return orderDiscountPrice;
    }
    
    public void setOrderDiscountPrice(BigDecimal orderDiscountPrice) {
        this.orderDiscountPrice = orderDiscountPrice;
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
