package com.bonc.cron.cronTest.jobmanager.entity;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 10:03
 */
public class JobHistoryVO {
    private int historyId;
    //开始执行的时间
    private Date executeTime;
    private ExecuteCondition condition;
    //0表示运行成功，1表示运行失败
    private int runStatus;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
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
}
