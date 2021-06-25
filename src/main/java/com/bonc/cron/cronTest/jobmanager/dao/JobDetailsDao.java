package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobHistoryPO;
import com.bonc.cron.cronTest.jobmanager.entity.PlanVO;

import java.util.List;

/**
 * 查看迁移详情需要的类
 * @author ZhengHang
 * @create 2021-06-10 14:49
 */
public interface JobDetailsDao {

    int selectJobHistoryId(String jobId);

    List<PlanVO> selectPlanQueue(int jobHistoryId);

    List<JobHistoryPO> selectJobHistory(String jobId);
}
