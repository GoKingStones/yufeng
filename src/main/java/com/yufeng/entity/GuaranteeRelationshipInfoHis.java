package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dh
 * 担保关系信息(历史)
 */
public class GuaranteeRelationshipInfoHis implements Serializable{
	
    /**
     */
    private static final long serialVersionUID = -6343744285172591845L;
    
    private String uniqueId;
    //用户内码(被担保人)
    private String internalCode;
    //形成关系用户内码(担保人)
    private String relateUserInternalCode;
    //关系状态
    private Integer status;
    //担保金额
    private BigDecimal assureMoney;
    //创建时间
    private Date createTime;
    
    public String getUniqueId() {
        return uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public String getInternalCode() {
        return internalCode;
    }
    
    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
    
    public String getRelateUserInternalCode() {
        return relateUserInternalCode;
    }
    
    public void setRelateUserInternalCode(String relateUserInternalCode) {
        this.relateUserInternalCode = relateUserInternalCode;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public BigDecimal getAssureMoney() {
        return assureMoney;
    }
    
    public void setAssureMoney(BigDecimal assureMoney) {
        this.assureMoney = assureMoney;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
	
	
	
	
	
	
}
