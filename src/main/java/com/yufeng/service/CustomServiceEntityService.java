package com.yufeng.service;

import com.yufeng.entity.CustomServiceEntity;

import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 */
public interface CustomServiceEntityService {

    public CustomServiceEntity insertCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public CustomServiceEntity updateCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public List<CustomServiceEntity> getCustomServiceEntityByWorkerId(int workerId);
    public List<CustomServiceEntity> getCustomServiceEntityByInternalCode(String internalCode);
}
