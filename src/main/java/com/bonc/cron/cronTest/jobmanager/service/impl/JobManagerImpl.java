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

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 17:16
 */
public class JobManagerImpl implements JobManagerService {

    private static Logger log = LoggerFactory.getLogger(JobManagerImpl.class);

    @Autowired
    JobDao jobDao;

    @Autowired
    JobDetailsDao jobDetailsDao;

    @Autowired
    JobStrategyDao jobStrategyDao;

    @Autowired
    PlanOrderDao planOrderDao;

    @Autowired
    SubTaskDao subTaskDao;

    @Override
    public boolean addJob(JobInputInfoVO jobInfo) {
        return false;
    }

    @Override
    public boolean deleteJob(String jobId) {
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
    public List<JobHistoryVO> getHistoryJob(String jobId) {
        return null;
    }

    @Override
    public List<JobDetailsVO> getJobDetails(String jobId) {
        return null;
    }

    @Override
    public List<JobDetailsVO> getJobHistoryDetails(int jobHistoryId) {
        return null;
    }

    @Override
    public boolean startJob(String jobId) {
        return false;
    }

    @Override
    public boolean stopJob(String jobId) {
        return false;
    }

    @Override
    public boolean purge(String jobId) {
        return false;
    }

    //用于编辑时获取原有的job信息
    public JobInputInfoVO getJob(String jobId){
        return null;
    }

    public void initSchedule() throws SchedulerException{

    }
}
