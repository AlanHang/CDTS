package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobInfoPO;
import com.bonc.cron.cronTest.jobmanager.entity.JobReturnPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:40
 */
@Mapper
public interface JobDao {

    int addJobInfo(JobInfoPO jobInfo);

    int deleteJobInfo(@Param("jobId") int jobId);

    int updateJobInfo(JobInfoPO jobInfo);

    List<JobInfoPO> selectAllJobInfo();

    List<JobReturnPO> selectAllReturnJobInfo(@Param("type") int type, @Param("status") int status, @Param("condition") String condition, @Param("order") int order);

    List<JobInfoPO> selectOneJobInfo(@Param("jobId") int jobId);
}
