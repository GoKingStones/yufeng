package com.yufeng.service;

import java.util.Map;

import com.yufeng.entity.GuaranteeRelationshipInfo;

/**
 * 担保关系业务处理层接口
 * @author dh
 */
public interface GuaranteeRelationshipService {
	
	//查询担保关系(id)
	public Map<String,Object> getById(String id);
	//查询担保关系(被担保人)
	public Map<String,Object> getByCode(String code);
	//查询担保关系(担保人)
	public Map<String,Object> getByRelateCode(String code);
	//创建担保关系
	public String foundGuaranteeRelationship(GuaranteeRelationshipInfo info);
	//取消担保关系
	public String deleteGuaranteeRelationship(String id);
	//修改担保关系
	public String updateGuaranteeRelationship(GuaranteeRelationshipInfo info);
	

}
