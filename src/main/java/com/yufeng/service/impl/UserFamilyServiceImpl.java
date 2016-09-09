package com.yufeng.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufeng.dao.UserFamilyDao;
import com.yufeng.dao.UserFamilyHistoryDao;
import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.UserFamilyService;
import com.yufeng.util.Utils;

/**
 * 用户家庭联系人业务处理层
 * @author dh
 */
@Service
public class UserFamilyServiceImpl implements UserFamilyService{
	
	@Autowired
    private UserFamilyDao userFamilyDao;
	@Autowired
    private UserFamilyHistoryDao userFamilyHistoryDao;
	
	//查询联系人信息
	public List<UserFamilyInfo> getUserFamilyByCode(String code){
		return userFamilyDao.getUserFamilyByCode(code);
	}
	
	//查询联系人信息
	public UserFamilyInfo getUserFamilyById(String uniqueId,String internalCode){
		return userFamilyDao.getUserFamilyById(uniqueId,internalCode);
	}
	
	//新建联系人信息
	public String insertUserFamily(List<UserFamilyInfo> userFamilyInfo){
	  //验证信息
        if(userFamilyInfo!=null&&userFamilyInfo.size()>0){
            for(UserFamilyInfo u:userFamilyInfo){
              //检查身份证号是否重复
                UserFamilyInfo info=userFamilyDao.getUserFamilyByCredentialsNumber(u.getCredentialsNumber());
                if(info!=null){
                    return Utils.RETURN_VALUE_CODE_99;//重复
                }
                //保存新建时间
                u.setCreateTime(new Date());
                userFamilyDao.insertUserFamily(u);
            }
            return Utils.RETURN_VALUE_CODE_1;
        }else{
            return Utils.RETURN_VALUE_CODE_0;
        }
		
	}
			
	//联系人信息修改
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyInfo.getUniqueId(),userFamilyInfo.getInternalCode());
		//检查信息是否存在
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		//保存修改时间
		userFamilyInfo.setModTime(new Date());
		return userFamilyDao.updateUserFamily(userFamilyInfo)+"";
	}
			
	//删除联系人信息
	public String deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyHistoryInfo.getUniqueId(),userFamilyHistoryInfo.getInternalCode());
		//检查信息是否存在
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		UserFamilyHistoryInfo u=new UserFamilyHistoryInfo();
		u.setCredentialsNumber(info.getCredentialsNumber());
		u.setCredentialsType(info.getCredentialsType());
		u.setDeleteOperator(userFamilyHistoryInfo.getDeleteOperator());//取得操作者
		u.setCreateTime(info.getCreateTime());
		u.setGender(info.getGender());
		u.setHighestEducation(info.getHighestEducation());
		u.setHighestEducationSchool(info.getHighestEducationSchool());
		u.setInternalCode(info.getInternalCode());
		u.setEmail(info.getEmail());
		u.setMailingAddress(info.getMailingAddress());
		u.setName(info.getName());
		u.setOrganization(info.getOrganization());
		u.setCellNo(info.getCellNo());
		u.setRelation(info.getRelation());
		u.setCreateTime(new Date());
		//保存联系人进历史表
		userFamilyHistoryDao.insertUserFamilyHistory(u);
		return userFamilyDao.deleteUserFamily(userFamilyHistoryInfo)+"";
	}

}
