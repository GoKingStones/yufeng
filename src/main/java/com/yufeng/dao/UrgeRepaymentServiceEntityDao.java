package com.yufeng.dao;

import com.yufeng.entity.UrgeRepaymentServiceEntity;

import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 * 催收服务DAO层
 */
public interface UrgeRepaymentServiceEntityDao {

    public int insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public int updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByWorkerId(int workerId);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByInternalCode(String internalCode);
}
