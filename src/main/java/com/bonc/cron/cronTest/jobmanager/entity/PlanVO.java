package com.bonc.cron.cronTest.jobmanager.entity;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:24
 */
public class PlanVO {
    private int planId;
    private int planHisId;
    private String planName;
    //计划运行的状态
    private int runStatus;

    public PlanVO(int planId, int planHisId, String planName, int runStatus) {
        this.planId = planId;
        this.planHisId = planHisId;
        this.planName = planName;
        this.runStatus = runStatus;
    }

    public PlanVO() {
    }

    public PlanVO(int planId) {
        this.planId = planId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getPlanHisId() {
        return planHisId;
    }

    public void setPlanHisId(int planHisId) {
        this.planHisId = planHisId;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }


    @Override
    public String toString() {
        return "PlanVO{" +
                "planId=" + planId +
                ", planHisId=" + planHisId +
                ", planName='" + planName + '\'' +
                ", runStatus=" + runStatus +
                '}';
    }
}
