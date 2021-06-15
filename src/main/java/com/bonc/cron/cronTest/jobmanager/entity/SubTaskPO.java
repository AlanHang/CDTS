package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:28
 */
public class SubTaskPO {
    private String taskId;
    private Date startTime;
    private Date endTime;
    private String completeDetails;
    private int runStatus;
    private String executeLog;
    private String speed;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public String getCompleteDetails() {
        return completeDetails;
    }

    public void setCompleteDetails(String completeDetails) {
        this.completeDetails = completeDetails;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public String getExecuteLog() {
        return executeLog;
    }

    public void setExecuteLog(String executeLog) {
        this.executeLog = executeLog;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
