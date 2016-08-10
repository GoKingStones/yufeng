package com.yufeng.service.impl;

import com.yufeng.dao.CustomServiceEntityDao;
import com.yufeng.entity.CustomServiceEntity;
import com.yufeng.service.CustomServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/7.
 */
public class CustomServiceEntityServiceImpl implements CustomServiceEntityService {

    @Autowired

    private CustomServiceEntityDao customServiceEntityDao;

    public int insertCustomServiceEntity(CustomServiceEntity customServiceEntity) {
        return customServiceEntityDao.insertCustomServiceEntity(customServiceEntity);
    }

    public int updateCustomServiceEntity(CustomServiceEntity customServiceEntity) {
        return 0;
    }

    public CustomServiceEntity getCustomServiceEntityByWorkerId(int workerId) {
        return null;
    }

    public CustomServiceEntity getCustomServiceEntityByInternalCode(String internalCode) {
        return null;
    }
}
