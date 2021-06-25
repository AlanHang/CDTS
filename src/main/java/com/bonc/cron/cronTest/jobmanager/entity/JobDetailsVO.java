package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:22
 */
public class JobDetailsVO {
    private int jobId;
    private String historyId;
    private List<PlanVO> plans;
    private int finishTime;
    private List<SubTaskVO> tasks;

    public JobDetailsVO(int jobId, String historyId, List<PlanVO> plans, int finishTime, List<SubTaskVO> tasks) {
        this.jobId = jobId;
        this.historyId = historyId;
        this.plans = plans;
        this.finishTime = finishTime;
        this.tasks = tasks;
    }

    public JobDetailsVO() {
    }

    public JobDetailsVO(int jobId) {
        this.jobId = jobId;
        this.plans = Arrays.asList(new PlanVO(1),new PlanVO(2));
        this.tasks = Arrays.asList(new SubTaskVO("1"),new SubTaskVO("2"));
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
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

    @Override
    public String toString() {
        return "JobDetailsVO{" +
                "jobId='" + jobId + '\'' +
                ", historyId=" + historyId +
                ", plans=" + plans +
                ", finishTime=" + finishTime +
                ", tasks=" + tasks +
                '}';
    }
}
