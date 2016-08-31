package com.yufeng.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yufeng.dao.GuaranteeRelationshipDao;
import com.yufeng.entity.GuaranteeRelationshipInfo;
import com.yufeng.service.GuaranteeRelationshipService;
import com.yufeng.util.Utils;

/**
 * 担保关系业务处理层
 * @author dh
 */
@Service
public class GuaranteeRelationshipServiceImpl implements GuaranteeRelationshipService{
	
	@Autowired
    private GuaranteeRelationshipDao guaranteeRelationshipDao;
	
	//查询担保关系(id)
	public Map<String,Object> getById(String uniqueId){
		Map<String,Object> map=new HashMap<String, Object>();
		GuaranteeRelationshipInfo list=guaranteeRelationshipDao.getById(uniqueId);
		map.put("result", list);
		return map;
	}
	
	//查询担保关系(被担保人)
	public Map<String,Object> getByCode(String internalCode){
		Map<String,Object> map=new HashMap<String, Object>();
		List<GuaranteeRelationshipInfo> list=guaranteeRelationshipDao.getByCode(internalCode);
		map.put("result", list);
		return map;
	}
	
	//查询担保关系(担保人)
	public Map<String,Object> getByRelateCode(String relateUserInternalCode){
		Map<String,Object> map=new HashMap<String, Object>();
		List<GuaranteeRelationshipInfo> list=guaranteeRelationshipDao.getByRelateCode(relateUserInternalCode);
		map.put("result", list);
		return map;
	}
	
	//创建担保关系
	public String foundGuaranteeRelationship(GuaranteeRelationshipInfo info){
	    int number=Utils.TOTAL_GUARANTEE;//限制担保人数,默认为4
		//检查共有几人为被担保人担保
		List<GuaranteeRelationshipInfo> passiveList=guaranteeRelationshipDao.getByCode(info.getInternalCode());
		//如果已经有4人了
		if(passiveList.size()>=number){
			return "2";//为其担保的人已经有4人
		}
		//检查担保人已经担保了几人
		List<GuaranteeRelationshipInfo> activeList=guaranteeRelationshipDao.getByRelateCode(info.getRelateUserInternalCode());
		//如果已经有4人了
		if(activeList.size()>=number){
			return "3";//担保人担保的人已经有4人
		}
		
		//先查找是否存在重复或者闲置状态的担保
		GuaranteeRelationshipInfo oldInfo=guaranteeRelationshipDao.getByAllCode(info.getInternalCode(),info.getRelateUserInternalCode());
		if(oldInfo!=null){
			//有历史
			if(oldInfo.getStatus()==0){
				//将原来的置为可以
				GuaranteeRelationshipInfo newInfo=new GuaranteeRelationshipInfo();
				newInfo.setUniqueId(oldInfo.getUniqueId());
				newInfo.setStatus(1);
				newInfo.setModTime(new Date());
				//原始数据存进历史表
				oldInfo.setUniqueId(UUID.randomUUID().toString());
				oldInfo.setCreateTime(new Date());//因为历史表只有创建时间,所以set在创建时间
				guaranteeRelationshipDao.insertHis(oldInfo);
				return guaranteeRelationshipDao.update(newInfo)+"";
			}else{
				return "99";//存在重复
			}
		}
		//新建担保
		info.setUniqueId(UUID.randomUUID().toString());
		info.setCreateTime(new Date());
		info.setStatus(1);
		return guaranteeRelationshipDao.insert(info)+"";
	}
	
	//取消担保关系
	public String deleteGuaranteeRelationship(String uniqueId){
		//原始数据存进历史表
		GuaranteeRelationshipInfo old=guaranteeRelationshipDao.getById(uniqueId);
		if(old!=null){
			old.setUniqueId(UUID.randomUUID().toString());
			old.setCreateTime(new Date());
			guaranteeRelationshipDao.insertHis(old);
		}else{
			return "0";//无关系
		}
		
		return guaranteeRelationshipDao.deleteGuaranteeRelationship(uniqueId)+"";
	}
	
	//修改担保关系
	public String updateGuaranteeRelationship(GuaranteeRelationshipInfo info){
		//原始数据存进历史表
		GuaranteeRelationshipInfo old=guaranteeRelationshipDao.getById(info.getUniqueId());
		if(old!=null){
			old.setUniqueId(UUID.randomUUID().toString());
			guaranteeRelationshipDao.insertHis(old);
			return guaranteeRelationshipDao.update(info)+"";
		}else{
			return "0";//不存在需要修改的信息
		}
		
	}

}
