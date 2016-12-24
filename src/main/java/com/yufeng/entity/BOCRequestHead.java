package com.yufeng.entity;

import javax.xml.bind.annotation.XmlElement;
/**
 * 
 * ClassName: BOCRequestMainParamEntity<br/> 
 * Description: 中银消费交易参数head
 * @author dh
 */
public class BOCRequestHead {
    
    private String transCode;
    
    private String transReqTime;
    
    private String transSeqNo;
    
    private String merchantId;
    
    private String customerId;
    
    private String version;
    
    public String getTransCode() {
        return transCode;
    }
    
    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }
    
    public String getTransReqTime() {
        return transReqTime;
    }
    
    public void setTransReqTime(String transReqTime) {
        this.transReqTime = transReqTime;
    }
    
    public String getTransSeqNo() {
        return transSeqNo;
    }
    
    public void setTransSeqNo(String transSeqNo) {
        this.transSeqNo = transSeqNo;
    }
    
    public String getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

}
