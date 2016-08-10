package com.yufeng.service;

import com.yufeng.entity.UrgeRepaymentServiceEntity;

/**
 * Created by kingstones on 16/8/7.
 */
public interface UrgeRepaymentServiceEntityService {

    public int insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public int updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public UrgeRepaymentServiceEntity getUrgeRepaymentServiceEntityByWorkerId(int workerId);
    public UrgeRepaymentServiceEntity getUrgeRepaymentServiceEntityByInternalCode(String internalCode);
}
