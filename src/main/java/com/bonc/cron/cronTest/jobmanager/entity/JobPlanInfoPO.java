package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * 记录job的plan队列
 * @author ZhengHang
 * @create 2021-06-10 9:38
 */
public class JobPlanInfoPO {
    private Integer jobId;
    private Integer planId;
    private Integer planOrder;

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

    public Integer getPlanOrder() {
        return planOrder;
    }

    public void setPlanOrder(Integer planOrder) {
        this.planOrder = planOrder;
    }

    public JobPlanInfoPO(Integer jobId, Integer planId, Integer planOrder) {
        this.jobId = jobId;
        this.planId = planId;
        this.planOrder = planOrder;
    }

    public JobPlanInfoPO() {
    }

    @Override
    public String toString() {
        return "JobPlanInfoPO{" +
                "jobId=" + jobId +
                ", planId=" + planId +
                ", planOrder=" + planOrder +
                '}';
    }
}
