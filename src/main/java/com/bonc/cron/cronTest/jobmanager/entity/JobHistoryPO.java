package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 9:36
 */
public class JobHistoryPO {
    private int jobHistoryId;
    private String jobId;
    private Date startTime;
    private Date endTime;
    //0表示运行成功，1表示运行失败
    private int runStatus;

    public int getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(int jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }
}
