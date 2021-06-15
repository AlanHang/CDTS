package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * 记录job的plan队列
 * @author ZhengHang
 * @create 2021-06-10 9:38
 */
public class JobPlanInfoPO {
    private String jobId;
    private String planId;
    private String planOrder;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanOrder() {
        return planOrder;
    }

    public void setPlanOrder(String planOrder) {
        this.planOrder = planOrder;
    }
}
