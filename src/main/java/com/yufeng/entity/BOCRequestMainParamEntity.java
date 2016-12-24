package com.yufeng.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * ClassName: BOCRequestMainParamEntity<br/> 
 * Description: 中银消费交易主参数(用于转换xml)
 * @author dh
 */
@XmlRootElement(name = "message") 
public class BOCRequestMainParamEntity {
    
    
    private BOCRequestHead head;
    
    private BOCRequestBody body;

    @XmlElement(name = "head")
    public BOCRequestHead getHead() {
        return head;
    }

    
    public void setHead(BOCRequestHead head) {
        this.head = head;
    }

    @XmlElement(name = "body")
    public BOCRequestBody getBody() {
        return body;
    }

    
    public void setBody(BOCRequestBody body) {
        this.body = body;
    }
    
    
    
    



}
