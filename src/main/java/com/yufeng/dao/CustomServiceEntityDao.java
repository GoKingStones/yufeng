package com.yufeng.dao;

import com.yufeng.entity.CustomServiceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 * 客户服务DAO层
 */
public interface CustomServiceEntityDao {

    public CustomServiceEntity getCustomServiceEntityById(int id);
    public CustomServiceEntity getSingleCustomServiceEntity(@Param("workerId")int workerId,@Param("internalCode")String internalCode,@Param("serviceTime")String serviceTime);
    public int insertCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public int updateCustomServiceEntity(CustomServiceEntity customServiceEntity);
    public List<CustomServiceEntity> getCustomServiceEntityByWorkerId(int workerId);
    public List<CustomServiceEntity> getCustomServiceEntityByInternalCode(String internalCode);
}
