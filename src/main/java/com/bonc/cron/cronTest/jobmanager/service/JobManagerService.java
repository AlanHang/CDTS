package com.bonc.cron.cronTest.jobmanager.service;

import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.result.JobDetailResult;
import com.bonc.cron.cronTest.result.Result;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 15:52
 */
public interface JobManagerService {

    Result<Boolean> addJob(JobInputInfoVO jobInfo);

    Result<Boolean> deleteJob(int jobId);

    Result<Boolean> updateJob(JobInputInfoVO jobInfo);

    Result<JobInputInfoVO> getJob(int jobId);

    Result<List<JobReturnVO>> getAllJobInfo(int type , int status , String condition , int order);

    Result<List<JobHistoryVO>> getHistoryJob(int jobId);

    //获取当前job执行详情
    Result<JobDetailResult> getJobDetails(int jobId, int pageNum, int pageSize);

    //获取历史job执行详情
    Result<JobDetailResult> getJobHistoryDetails(String jobHistoryId, int pageNum, int pageSize);

    Result<Boolean> startJob(int jobId);

    Result<Boolean> stopJob(int jobId);

    Result<Boolean> purge(int jobId);

    Result<List<SubTaskVO>> getSubTasks(int planHistoryId);

    void initSchedule() throws SchedulerException;
}
