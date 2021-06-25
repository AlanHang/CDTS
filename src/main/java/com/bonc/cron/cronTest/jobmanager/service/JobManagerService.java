package com.bonc.cron.cronTest.jobmanager.service;

import com.bonc.cron.cronTest.jobmanager.entity.JobDetailsVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobHistoryVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInfoVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 15:52
 */
public interface JobManagerService {

    boolean addJob(JobInputInfoVO jobInfo);

    boolean deleteJob(int jobId);

    boolean updateJob(JobInputInfoVO jobInfo);

    List<JobInfoVO> getAllJobInfo();

    List<JobHistoryVO> getHistoryJob(int jobId);

    //获取当前job执行详情
    List<JobDetailsVO> getJobDetails(int jobId);

    //获取历史job执行详情
    List<JobDetailsVO> getJobHistoryDetails(String jobHistoryId);

    boolean startJob(int jobId);

    boolean stopJob(int jobId);

    boolean purge(int jobId);

    JobInputInfoVO getJob(int jobId);

    void initSchedule() throws SchedulerException;
}
