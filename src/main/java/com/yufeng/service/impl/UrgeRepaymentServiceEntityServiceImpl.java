package com.yufeng.service.impl;

import com.yufeng.dao.UrgeRepaymentServiceEntityDao;
import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.service.UrgeRepaymentServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/7.
 */
public class UrgeRepaymentServiceEntityServiceImpl implements UrgeRepaymentServiceEntityService {

    @Autowired

    private UrgeRepaymentServiceEntityDao urgeRepaymentServiceEntityDao;

    public int insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity) {
        return 0;
    }

    public int updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity) {
        return 0;
    }

    public UrgeRepaymentServiceEntity getUrgeRepaymentServiceEntityByWorkerId(int workerId) {
        return null;
    }

    public UrgeRepaymentServiceEntity getUrgeRepaymentServiceEntityByInternalCode(String internalCode) {
        return null;
    }
}
