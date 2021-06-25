package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobStrategyInfoPO;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-11 11:28
 */
public interface JobStrategyDao {

    int addJobStrategy(List<JobStrategyInfoPO> strategy);

    int deleteJobStrategy(String jobId);

    int updateJobStrategy(List<JobStrategyInfoPO> strategy);

    List<JobStrategyInfoPO> selectAllJobStrategy(String jobId);

    String selectOneJobStrategy(String jobId , String Key);
}
