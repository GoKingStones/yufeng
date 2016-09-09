package com.yufeng.service;

import com.yufeng.entity.WorkerInfo;

/**
 * Created by kingstones on 16/8/7.
 */
public interface WorkerInfoService {

    public WorkerInfo insertWorkerInfo(WorkerInfo workerInfo);

    public WorkerInfo updateWorkerInfo(WorkerInfo workerInfo);

    public WorkerInfo updateWorkerInfoByAdmin(WorkerInfo workerInfo);

    public WorkerInfo getWorkerInfoByWorkerId(int workerId);
    public WorkerInfo getWorkerInfoByWorkerName(String workerName);
    public WorkerInfo getWorkerInfoByPhoneNumber(String phoneNumber);
}