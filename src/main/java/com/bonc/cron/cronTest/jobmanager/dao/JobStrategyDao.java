package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobStrategyInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-11 11:28
 */
@Mapper
public interface JobStrategyDao {

    int addJobStrategy(List<JobStrategyInfoPO> strategy);

//    int deleteJobStrategy(@Param("jobId") int jobId);

    int updateJobStrategy(List<JobStrategyInfoPO> strategy);

    List<JobStrategyInfoPO> selectAllJobStrategy(@Param("jobId") int jobId);

    String selectOneJobStrategy(@Param("jobId") int jobId, @Param("key") String key);
}
