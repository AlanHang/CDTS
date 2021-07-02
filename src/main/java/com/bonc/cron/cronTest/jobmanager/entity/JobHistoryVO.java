package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:03
 */
public class JobHistoryVO {
    private String jobHisId;
    //开始执行的时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    private ExecuteCondition condition;
    //0表示运行成功，1表示运行失败
    private int runStatus;

    public JobHistoryVO(String jobHisId, Date startTime, ExecuteCondition condition, int runStatus) {
        this.jobHisId = jobHisId;
        this.startTime = startTime;
        this.condition = condition;
        this.runStatus = runStatus;
    }

    public JobHistoryVO() {
    }

    public String getJobHisId() {
        return jobHisId;
    }

    public void setJobHisId(String jobHisId) {
        this.jobHisId = jobHisId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

    @Override
    public String toString() {
        return "JobHistoryVO{" +
                "jobHisId=" + jobHisId +
                ", startTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime) +
                ", condition=" + condition +
                ", runStatus=" + runStatus +
                '}';
    }
}
