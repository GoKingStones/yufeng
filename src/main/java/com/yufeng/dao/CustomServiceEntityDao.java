package com.yufeng.dao;

import com.yufeng.entity.CustomServiceEntity;

/**
 * Created by kingstones on 16/8/7.
 * 客户服务DAO层
 */
public interface CustomServiceEntityDao {

    public int insertCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public int updateCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public CustomServiceEntity getCustomServiceEntityByWorkerId(int workerId);
    public CustomServiceEntity getCustomServiceEntityByInternalCode(String internalCode);
}
