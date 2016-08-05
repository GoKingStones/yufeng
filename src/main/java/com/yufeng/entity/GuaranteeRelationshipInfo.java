package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dh
 * 担保关系信息
 */
public class GuaranteeRelationshipInfo implements Serializable{
	
	private String id;
	//用户内码(被担保人)
	private String internal_code;
	//形成关系用户内码(担保人)
	private String relate_user_internal_code;
	//关系状态
	private Integer status;
	//担保金额
	private BigDecimal assure_money;
	//创建时间
	private Date create_time;
	//修改时间
	private Date mod_time;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInternal_code() {
		return internal_code;
	}
	public void setInternal_code(String internal_code) {
		this.internal_code = internal_code;
	}
	public String getRelate_user_internal_code() {
		return relate_user_internal_code;
	}
	public void setRelate_user_internal_code(String relate_user_internal_code) {
		this.relate_user_internal_code = relate_user_internal_code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getAssure_money() {
		return assure_money;
	}
	public void setAssure_money(BigDecimal assure_money) {
		this.assure_money = assure_money;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getMod_time() {
		return mod_time;
	}
	public void setMod_time(Date mod_time) {
		this.mod_time = mod_time;
	}
	
	
	
	
	
	
	

}
