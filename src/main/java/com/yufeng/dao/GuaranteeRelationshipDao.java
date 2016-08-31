package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.GuaranteeRelationshipInfo;

/**
 * 担保关系dao层
 * @author dh
 */
public interface GuaranteeRelationshipDao {
	
	//查询担保关系
	public GuaranteeRelationshipInfo getById(String uniqueId);
	//按被担保人查询
	public List<GuaranteeRelationshipInfo> getByCode(String internalCode);
	//按担保人查询
	public List<GuaranteeRelationshipInfo> getByRelateCode(String relateUserInternalCode);
	//按被担保人和担保人查询
	public GuaranteeRelationshipInfo getByAllCode(String internalCode,String relateUserInternalCode);
	//新建担保关系
	public int insert(GuaranteeRelationshipInfo info);
	//修改担保关系
	public int update(GuaranteeRelationshipInfo info);
	//取消担保关系
	public int deleteGuaranteeRelationship(String uniqueId);
	
	
	//新建担保关系历史
	public int insertHis(GuaranteeRelationshipInfo info);

}
