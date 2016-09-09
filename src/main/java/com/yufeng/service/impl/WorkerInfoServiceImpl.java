package com.yufeng.service.impl;

import com.yufeng.dao.WorkerInfoDao;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/7.
 */
public class WorkerInfoServiceImpl implements WorkerInfoService {



    @Autowired
    private WorkerInfoDao workerInfoDao;

    public WorkerInfo insertWorkerInfo(WorkerInfo workerInfo) {

        int result = workerInfoDao.insertWorkerInfo(workerInfo);
        if (result==1) {
            return workerInfoDao.getWorkerInfoByPhoneNumber(workerInfo.getPhoneNumber());
        }else {
            return null;
        }
    }

    public WorkerInfo updateWorkerInfo(WorkerInfo workerInfo) {

        int result = workerInfoDao.updateWorkerInfo(workerInfo);

        if (result==1) {
            return workerInfoDao.getWorkInfoByWorkerId(workerInfo.getWorkerId());
        }else {
            return null;
        }
    }

    public WorkerInfo updateWorkerInfoByAdmin(WorkerInfo workerInfo) {

        int result = workerInfoDao.updateWorkerInfoByAdmin(workerInfo);
        if (result==1) {
            return workerInfoDao.getWorkInfoByWorkerId(workerInfo.getWorkerId());
        }else {
            return null;
        }
    }

    public WorkerInfo getWorkerInfoByWorkerId(int workerId) {
        return workerInfoDao.getWorkInfoByWorkerId(workerId);
    }


    public WorkerInfo getWorkerInfoByWorkerName(String workerName) {
        return workerInfoDao.getWorkerInfoByWorkerName(workerName);
    }

    public WorkerInfo getWorkerInfoByPhoneNumber(String phoneNumber) {
        return workerInfoDao.getWorkerInfoByPhoneNumber(phoneNumber);
    }


}
