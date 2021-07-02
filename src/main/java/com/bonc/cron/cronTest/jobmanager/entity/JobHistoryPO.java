package com.bonc.cron.cronTest.jobmanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 9:36
 */
public class JobHistoryPO {

    private String jobHisId;

    private Integer jobId;

    private Date startTime;

    private String completeDetail;

    //0表示运行成功，1表示运行失败
    private Integer runStatus;

    public JobHistoryPO(String jobHisId, Integer jobId, Date startTime, String completeDetail, Integer runStatus) {
        this.jobHisId = jobHisId;
        this.jobId = jobId;
        this.startTime = startTime;
        this.completeDetail = completeDetail;
        this.runStatus = runStatus;
    }

    public JobHistoryPO(String jobHisId, Date startTime, String completeDetail, Integer runStatus) {
        this.jobHisId = jobHisId;
        this.startTime = startTime;
        this.completeDetail = completeDetail;
        this.runStatus = runStatus;
    }

    public JobHistoryPO() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getJobHisId() {
        return jobHisId;
    }

    public void setJobHisId(String jobHisId) {
        this.jobHisId = jobHisId;
    }

    public String getCompleteDetail() {
        return completeDetail;
    }

    public void setCompleteDetail(String completeDetail) {
        this.completeDetail = completeDetail;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }


    @Override
    public String toString() {
        return "JobHistoryPO{" +
                "jobHisId='" + jobHisId + '\'' +
                ", jobId=" + jobId +
                ", startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime)  +
                ", completeDetail='" + completeDetail + '\'' +
                ", runStatus=" + runStatus +
                '}';
    }
}
