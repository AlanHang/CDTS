package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobInfoPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:40
 */
public interface JobDao {

    int addJobInfo(JobInfoPO jobInfo);

    int deleteJobInfo(String jobId);

    int updateJobInfo(JobInfoPO jobInfo);

    List<JobInfoPO> selectAllJobInfo();
}
