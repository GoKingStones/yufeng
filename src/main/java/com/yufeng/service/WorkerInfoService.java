package com.yufeng.service;

import com.yufeng.entity.WorkerInfo;

/**
 * Created by kingstones on 16/8/7.
 */
public interface WorkerInfoService {

    public int insertWorkerInfo(WorkerInfo workerInfo);

    public int updateWorkerInfo(WorkerInfo workerInfo);

    public WorkerInfo getWorkerInfoByOrgId(String orgId);
    public WorkerInfo getWorkerInfoByWorkerName(String workerName);
    public WorkerInfo getWorkerInfoByPhoneNumber(String phoneNumber);
}