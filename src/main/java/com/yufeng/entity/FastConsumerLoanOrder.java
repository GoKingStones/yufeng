package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dh
 * 快速消费品分期订单
 */
public class FastConsumerLoanOrder implements Serializable{
	
	private String id;
	//订单id
	private String order_id;
	//订单类型
	private String order_type;
	//购买用户内码
	private String user_internal_code;
	//订单状态
	private String order_state;
	//发票号
	private String invoice_number;
	//总金额
	private BigDecimal total_amount;
	//折扣价
	private BigDecimal discount_price;
	//订单折扣价
	private BigDecimal order_discount_price;
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getUser_internal_code() {
		return user_internal_code;
	}
	public void setUser_internal_code(String user_internal_code) {
		this.user_internal_code = user_internal_code;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	public BigDecimal getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(BigDecimal discount_price) {
		this.discount_price = discount_price;
	}
	public BigDecimal getOrder_discount_price() {
		return order_discount_price;
	}
	public void setOrder_discount_price(BigDecimal order_discount_price) {
		this.order_discount_price = order_discount_price;
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
