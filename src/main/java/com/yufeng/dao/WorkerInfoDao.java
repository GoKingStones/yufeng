package com.yufeng.dao;

import com.yufeng.entity.WorkerInfo;

/**
 * Created by kingstones on 16/8/7.
 * 客服员工基本信息DAO层
 */
public interface WorkerInfoDao {

    public int insertWorkerInfo(WorkerInfo workerInfo);
    public int updateWorkerInfoByAdmin(WorkerInfo workerInfo);
    public int updateWorkerInfo(WorkerInfo workerInfo);
    public WorkerInfo getWorkInfoByWorkerId(int workerId);
    public WorkerInfo getWorkerInfoByWorkerName(String workerName);
    public WorkerInfo getWorkerInfoByPhoneNumber(String phoneNumber);
}
