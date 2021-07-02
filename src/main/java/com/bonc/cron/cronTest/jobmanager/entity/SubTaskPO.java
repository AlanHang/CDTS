package com.bonc.cron.cronTest.jobmanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:28
 */
public class SubTaskPO {

    private String applicationId;

    private Date startTime;

    private Date endTime;

    private String completeDetail;

    private Integer runStatus;

    private String log;

    private String speed;

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

    public String getCompleteDetail() {
        return completeDetail;
    }

    public void setCompleteDetail(String completeDetail) {
        this.completeDetail = completeDetail;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public SubTaskPO(String applicationId, Date startTime, Date endTime, String completeDetail, Integer runStatus,
                     String log, String speed) {
        this.applicationId = applicationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.completeDetail = completeDetail;
        this.runStatus = runStatus;
        this.log = log;
        this.speed = speed;
    }

    public SubTaskPO() {
    }

    @Override
    public String toString() {
        return "SubTaskPO{" +
                "taskId='" + applicationId + '\'' +
                ", startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) +
                ", endTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime) +
                ", completeDetail='" + completeDetail + '\'' +
                ", runStatus=" + runStatus +
                ", log='" + log + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
