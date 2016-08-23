package com.yufeng.service;

import com.yufeng.entity.UrgeRepaymentServiceEntity;

import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 */
public interface UrgeRepaymentServiceEntityService {

    public UrgeRepaymentServiceEntity insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public UrgeRepaymentServiceEntity updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByWorkerId(int workerId);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByInternalCode(String internalCode);
}
