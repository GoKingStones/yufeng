package com.yufeng.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufeng.dao.UserFinancialAccountDao;
import com.yufeng.entity.UserFinancialAccountInfo;
import com.yufeng.service.UserFinancialAccountService;
import com.yufeng.util.Utils;

/**
 * 用户金融业务处理层
 * @author dh
 */
@Service
public class UserFinancialAccountServiceImpl implements UserFinancialAccountService{
	
	@Autowired
    private UserFinancialAccountDao userFinancialAccountDao;
	
	//查询金融账户信息
	public List<UserFinancialAccountInfo> getUserFinancialAccountByCode(String internalCode){
		List<UserFinancialAccountInfo> info=userFinancialAccountDao.getUserFinancialAccountByCode(internalCode);
		return info;
	}
	
	//查询金融账户信息
	public UserFinancialAccountInfo getUserFinancialAccountById(String uniqueId,String internalCode){
		UserFinancialAccountInfo info=userFinancialAccountDao.getUserFinancialAccountById(uniqueId,internalCode);
		return info;
	}
			
	//新建金融账户信息
	public String insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		UserFinancialAccountInfo info=userFinancialAccountDao.getUserFinancialAccountByAccountId(userFinancialAccountInfo.getFinancialConsumeAccountId());
		if(info!=null){
			return Utils.RETURN_VALUE_CODE_99;//存在重复
		}
		userFinancialAccountInfo.setCreateTime(new Date());
		return userFinancialAccountDao.insertUserFinancialAccount(userFinancialAccountInfo)+"";
	}
				
	//金融账户信息修改
	public String updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		UserFinancialAccountInfo info=userFinancialAccountDao.getUserFinancialAccountById(userFinancialAccountInfo.getUniqueId(),userFinancialAccountInfo.getInternalCode());
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		userFinancialAccountInfo.setModTime(new Date());
		return userFinancialAccountDao.updateUserFinancialAccount(userFinancialAccountInfo)+"";
	}
				
	//删除金融账户信息
	public String deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		UserFinancialAccountInfo info=userFinancialAccountDao.getUserFinancialAccountById(userFinancialAccountInfo.getUniqueId(),userFinancialAccountInfo.getInternalCode());
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		return userFinancialAccountDao.deleteUserFinancialAccount(userFinancialAccountInfo)+"";	
	}

}
