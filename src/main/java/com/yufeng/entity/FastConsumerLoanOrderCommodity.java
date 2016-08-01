package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author dh
 * 快速消费品分期订单商品
 */
public class FastConsumerLoanOrderCommodity implements Serializable{
	
	//id
	private String id;
	//商品id
	private String commodity_id;
	//商品名
	private String commodity_name;
	//订单id
	private String order_id;
	//价格
	private BigDecimal price;
	//数量
	private Integer number;
	//购买用户内码
	private String user_internal_code;
	//商户内码
	private String seller_internal_code;
	//总金额
	private BigDecimal total_amount;
	//信息状态
	private String information_state;
	//支付方式
	private String pay_method;
	//支付名
	private String pay_name;
	//支付编码
	private String pay_code;
	//外部支付号
	private String external_pay_number;
	//支付时间
	private Date pay_time;
	//下单时间
	private Date order_time;
	//发货时间
	private Date send_time;
	//支付信息
	private String pay_message;
	//收货时间
	private Date receipt_time;
	//完成时间
	private Date finish_time;
	//折扣价
	private BigDecimal discount_price;
	//是否匿名
	private boolean anonymous;
	//创建时间
	private Date found_time;
	//修改时间
	private Date update_time;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	public String getInformation_state() {
		return information_state;
	}
	public void setInformation_state(String information_state) {
		this.information_state = information_state;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	public String getPay_code() {
		return pay_code;
	}
	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}
	public String getExternal_pay_number() {
		return external_pay_number;
	}
	public void setExternal_pay_number(String external_pay_number) {
		this.external_pay_number = external_pay_number;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public String getPay_message() {
		return pay_message;
	}
	public void setPay_message(String pay_message) {
		this.pay_message = pay_message;
	}
	public Date getReceipt_time() {
		return receipt_time;
	}
	public void setReceipt_time(Date receipt_time) {
		this.receipt_time = receipt_time;
	}
	public Date getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}
	public BigDecimal getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(BigDecimal discount_price) {
		this.discount_price = discount_price;
	}
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	public Date getFound_time() {
		return found_time;
	}
	public void setFound_time(Date found_time) {
		this.found_time = found_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
	
	
}
