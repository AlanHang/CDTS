package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobHistoryPO;
import com.bonc.cron.cronTest.jobmanager.entity.PlanVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查看迁移详情需要的类
 *
 * @author ZhengHang
 * @create 2021-06-10 14:49
 */
@Mapper
public interface JobDetailsDao {

    String selectJobHistoryId(@Param("jobId") int jobId);

    List<PlanVO> selectPlanQueue(@Param("jobHistoryId") String jobHistoryId);

    List<JobHistoryPO> selectJobHistory(@Param("jobId") int jobId);

}
