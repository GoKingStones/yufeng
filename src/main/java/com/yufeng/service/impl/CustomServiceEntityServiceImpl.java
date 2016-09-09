package com.yufeng.service.impl;

import com.yufeng.dao.CustomServiceEntityDao;
import com.yufeng.entity.CustomServiceEntity;
import com.yufeng.service.CustomServiceEntityService;
import com.yufeng.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 */
public class CustomServiceEntityServiceImpl implements CustomServiceEntityService {

    @Autowired

    private CustomServiceEntityDao customServiceEntityDao;

    public CustomServiceEntity insertCustomServiceEntity(CustomServiceEntity customServiceEntity) {

        int result =  customServiceEntityDao.insertCustomServiceEntity(customServiceEntity);
        if(result==1) {
            return customServiceEntityDao.getSingleCustomServiceEntity(customServiceEntity.getWorkerId(),customServiceEntity.getInternalCode(), DateUtil.dateToString(customServiceEntity.getServiceTime()));
        }else {
            return null;
        }
    }

    public CustomServiceEntity updateCustomServiceEntity(CustomServiceEntity customServiceEntity) {

        int result =  customServiceEntityDao.updateCustomServiceEntity(customServiceEntity);
        if(result==1) {
            return customServiceEntityDao.getCustomServiceEntityById(customServiceEntity.getId());
        }else {
            return null;
        }
    }

    public List<CustomServiceEntity> getCustomServiceEntityByWorkerId(int workerId) {
        return customServiceEntityDao.getCustomServiceEntityByWorkerId(workerId);
    }

    public List<CustomServiceEntity> getCustomServiceEntityByInternalCode(String internalCode) {
        return customServiceEntityDao.getCustomServiceEntityByInternalCode(internalCode);
    }
}
