package com.yufeng.service.impl;

import com.yufeng.dao.UrgeRepaymentServiceEntityDao;
import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.service.UrgeRepaymentServiceEntityService;
import com.yufeng.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 */
public class UrgeRepaymentServiceEntityServiceImpl implements UrgeRepaymentServiceEntityService {

    @Autowired

    private UrgeRepaymentServiceEntityDao urgeRepaymentServiceEntityDao;

    public UrgeRepaymentServiceEntity insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity) {
        int result = urgeRepaymentServiceEntityDao.insertUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
        if(result==1) {
            System.out.println(DateUtil.dateToString(urgeRepaymentServiceEntity.getUrgeTime()));
            return urgeRepaymentServiceEntityDao.getSingleUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity.getWorkerId(),urgeRepaymentServiceEntity.getInternalCode(), DateUtil.dateToString(urgeRepaymentServiceEntity.getUrgeTime()));
        }else {
            return null;
        }
    }

    public UrgeRepaymentServiceEntity updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity) {
        int result = urgeRepaymentServiceEntityDao.updateUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
        if(result==1) {
            return urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityById(urgeRepaymentServiceEntity.getId());
        }else {
            return null;
        }
    }

    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByWorkerId(int workerId) {
        return urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityByWorkerId(workerId);
    }

    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByInternalCode(String internalCode) {
        return urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityByInternalCode(internalCode);
    }
}
