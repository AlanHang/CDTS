package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 11:39
 */
public class SubTaskVO {
    private String applicationId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private ExecuteCondition condition;
    private int runStatus;
    private String executeLog;
    private String speed;

    public SubTaskVO(String applicationId, Date startTime, Date endTime, ExecuteCondition condition, int runStatus,
                     String executeLog, String speed) {
        this.applicationId = applicationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.condition = condition;
        this.runStatus = runStatus;
        this.executeLog = executeLog;
        this.speed = speed;
    }

    public SubTaskVO() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    public ExecuteCondition getCondition() {
        return condition;
    }

    public void setCondition(ExecuteCondition condition) {
        this.condition = condition;
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

    @Override
    public String toString() {
        return "SubTaskVO{" +
                "applicationId='" + applicationId + '\'' +
                ", startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) +
                ", endTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime) +
                ", condition=" + condition +
                ", runStatus=" + runStatus +
                ", executeLog='" + executeLog + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
