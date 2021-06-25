package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * 记录job的plan队列
 * @author ZhengHang
 * @create 2021-06-10 9:38
 */
public class JobPlanInfoPO {
    private int jobId;
    private int planId;
    private String planOrder;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanOrder() {
        return planOrder;
    }

    public void setPlanOrder(String planOrder) {
        this.planOrder = planOrder;
    }
}
