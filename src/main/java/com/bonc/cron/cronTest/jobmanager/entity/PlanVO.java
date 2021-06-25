package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:24
 */
public class PlanVO {
    private int planId;
    private int planHistoryId;
    private String planName;
    //计划运行的状态
    private int planStatus;

    public PlanVO(int planId, int planHistoryId, String planName, int planStatus) {
        this.planId = planId;
        this.planHistoryId = planHistoryId;
        this.planName = planName;
        this.planStatus = planStatus;
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

    public int getPlanHistoryId() {
        return planHistoryId;
    }

    public void setPlanHistoryId(int planHistoryId) {
        this.planHistoryId = planHistoryId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(int planStatus) {
        this.planStatus = planStatus;
    }

    @Override
    public String toString() {
        return "PlanVO{" +
                "planId=" + planId +
                ", planHistoryId=" + planHistoryId +
                ", planName='" + planName + '\'' +
                ", planStatus=" + planStatus +
                '}';
    }
}
