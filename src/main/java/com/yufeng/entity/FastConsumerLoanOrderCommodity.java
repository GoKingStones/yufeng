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
//
//    //id
//	private String uniqueId;
//	//商品id
//	private String commodityId;
//	//商品名
//	private String commodityName;
//	//订单id
//	private long orderId;
//	//价格
//	private BigDecimal price;
//	//数量
//	private Integer number;
//	//购买用户内码
//	private String userInternalCode;
//	//商户内码
//	private String sellerInternalCode;
//	//总金额
//	private BigDecimal totalAmount;
//	//信息状态
//	private String informationState;
//	//支付方式
//	private String payMethod;
//	//支付名
//	private String payName;
//	//支付编码
//	private String payCode;
//	//外部支付号
//	private String externalPayNumber;
//	//支付时间
//	private Date payTime;
//	//下单时间
//	private Date orderTime;
//	//发货时间
//	private Date sendTime;
//	//支付信息
//	private String payMessage;
//	//收货时间
//	private Date receiptTime;
//	//完成时间
//	private Date finishTime;
//	//折扣价
//	private BigDecimal discountPrice;
//	//是否匿名
//	private Boolean anonymous;


    private String uniqueId;
    //商品id
	private String commodityId;
	//商品名
	private String commodityName;
	//订单id
	private long orderId;
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

    private String commodityState;

	//创建时间
    private Date createTime;
    //修改时间
    private Date modTime;

    public String getCommodityState() {

        return commodityState;
    }

    public void setCommodityState(String commodityState) {
        this.commodityState = commodityState;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
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
