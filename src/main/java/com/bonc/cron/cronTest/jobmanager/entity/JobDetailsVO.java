package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:22
 */
public class JobDetailsVO {
    private String jobId;
    private int historyId;
    private List<PlanVO> plans;
    private int finishTime;
    private List<SubTaskVO> tasks;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public List<PlanVO> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanVO> plans) {
        this.plans = plans;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public List<SubTaskVO> getTasks() {
        return tasks;
    }

    public void setTasks(List<SubTaskVO> tasks) {
        this.tasks = tasks;
    }
}
