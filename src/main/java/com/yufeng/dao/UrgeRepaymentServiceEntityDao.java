package com.yufeng.dao;

import com.yufeng.entity.UrgeRepaymentServiceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 * 催收服务DAO层
 */
public interface UrgeRepaymentServiceEntityDao {

    public UrgeRepaymentServiceEntity getUrgeRepaymentServiceEntityById(int id);
    public UrgeRepaymentServiceEntity getSingleUrgeRepaymentServiceEntity(@Param("workerId")int workerId,@Param("internalCode")String internalCode,@Param("urgeTime")String urgeTime);
    public int insertUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public int updateUrgeRepaymentServiceEntity(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByWorkerId(int workerId);
    public List<UrgeRepaymentServiceEntity> getUrgeRepaymentServiceEntityByInternalCode(String internalCode);
}
