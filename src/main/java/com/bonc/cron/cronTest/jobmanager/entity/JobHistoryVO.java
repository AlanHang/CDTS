package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:03
 */
public class JobHistoryVO {
    private String historyId;
    //开始执行的时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date executeTime;
    private ExecuteCondition condition;
    //0表示运行成功，1表示运行失败
    private int runStatus;

    public JobHistoryVO(String historyId, Date executeTime, ExecuteCondition condition, int runStatus) {
        this.historyId = historyId;
        this.executeTime = executeTime;
        this.condition = condition;
        this.runStatus = runStatus;
    }

    public JobHistoryVO() {
    }

    public JobHistoryVO(String historyId) {
        this.historyId = historyId;
        this.executeTime = new Date();
        this.condition = new ExecuteCondition();
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
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
                "historyId=" + historyId +
                ", executeTime=" + executeTime +
                ", condition=" + condition +
                ", runStatus=" + runStatus +
                '}';
    }
}
