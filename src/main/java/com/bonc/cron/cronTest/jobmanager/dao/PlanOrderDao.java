package com.bonc.cron.cronTest.jobmanager.dao;

import com.bonc.cron.cronTest.jobmanager.entity.JobPlanInfoPO;

/**
 * @author ZhengHang
 * @create 2021-06-10 14:46
 */
public interface PlanOrderDao {
    int addPlanOrder(JobPlanInfoPO planOrder);
    int deletePlanOrder(String jobId,int planId);
}
