package com.bonc.cron.cronTest.jobmanager.service.impl;

import com.bonc.cron.cronTest.jobmanager.dao.*;
import com.bonc.cron.cronTest.jobmanager.entity.JobDetailsVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobHistoryVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInfoVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;
import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 17:16
 */
@Service
public class JobManagerImpl implements JobManagerService {

    private static Logger log = LoggerFactory.getLogger(JobManagerImpl.class);

//    @Autowired
//    JobDao jobDao;
//
//    @Autowired
//    JobDetailsDao jobDetailsDao;
//
//    @Autowired
//    JobStrategyDao jobStrategyDao;
//
//    @Autowired
//    PlanOrderDao planOrderDao;
//
//    @Autowired
//    SubTaskDao subTaskDao;

    @Override
    public boolean addJob(JobInputInfoVO jobInfo) {
        return false;
    }

    @Override
    public boolean deleteJob(int jobId) {
        return false;
    }

    @Override
    public boolean updateJob(JobInputInfoVO jobInfo) {
        return false;
    }

    @Override
    public List<JobInfoVO> getAllJobInfo() {
        return null;
    }


    @Override
    public List<JobHistoryVO> getHistoryJob(int jobId) {
        return null;
    }

    @Override
    public List<JobDetailsVO> getJobDetails(int jobId) {
        return null;
    }

    @Override
    public List<JobDetailsVO> getJobHistoryDetails(String jobHistoryId) {
        return null;
    }

    @Override
    public boolean startJob(int jobId) {
        return false;
    }

    @Override
    public boolean stopJob(int jobId) {
        return false;
    }

    @Override
    public boolean purge(int jobId) {
        return false;
    }

    @Override
    public JobInputInfoVO getJob(int jobId) {
        return null;
    }

    //用于编辑时获取原有的job信息
    public JobInputInfoVO getJob(String jobId){
        return null;
    }

    public void initSchedule() throws SchedulerException{

    }
}
