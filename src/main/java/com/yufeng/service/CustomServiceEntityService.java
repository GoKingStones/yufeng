package com.yufeng.service;

import com.yufeng.entity.CustomServiceEntity;

/**
 * Created by kingstones on 16/8/7.
 */
public interface CustomServiceEntityService {

    public int insertCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public int updateCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public CustomServiceEntity getCustomServiceEntityByWorkerId(int workerId);
    public CustomServiceEntity getCustomServiceEntityByInternalCode(String internalCode);
}
