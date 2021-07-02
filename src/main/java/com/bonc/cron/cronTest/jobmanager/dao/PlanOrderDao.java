package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobPlanInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:46
 */
@Mapper
public interface PlanOrderDao {

    int addPlanOrder(JobPlanInfoPO planOrder);

    int deletePlanOrder(@Param("jobId") int jobId, @Param("planId") int planId);

    int selectMaxPlanOrder(JobPlanInfoPO planOrder);

    int addPlanOrderByJob(@Param("jobId") int jobId, @Param("planIds") List<Integer> planIds);

    int deletePlanOrderByJobId(@Param("jobId") int jobId);

    List<Integer> selectAllByJobId(@Param("jobId") int jobId);
}
