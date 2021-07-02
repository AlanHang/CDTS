package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-09 14:29
 */
public class JobReturnVO {
    private int jobId;
    private String jobName;
    private String jobRemark;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date jobCreateTime;
    //标识job运行的类型，0为单次job,1为周期性job
    private int jobType;
    //触发时间
    private String startTime;
    //标识job的状态，0为关闭，1为开启，2为失败
    private int jobStatus;
    //job子任务的执行情况
    private ExecuteCondition condition;
    private long totalTime;

    public JobReturnVO(int jobId, String jobName, String jobRemark, Date jobCreateTime, int jobType, String startTime,
                       int jobStatus, ExecuteCondition condition, long totalTime) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.startTime = startTime;
        this.jobStatus = jobStatus;
        this.condition = condition;
        this.totalTime = totalTime;
    }

    public JobReturnVO() {
    }


    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobRemark() {
        return jobRemark;
    }

    public void setJobRemark(String jobRemark) {
        this.jobRemark = jobRemark;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public ExecuteCondition getCondition() {
        return condition;
    }

    public void setCondition(ExecuteCondition condition) {
        this.condition = condition;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "JobInfoVO{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                ", jobCreateTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jobCreateTime) +
                ", jobType=" + jobType +
                ", startTime='" + startTime + '\'' +
                ", jobStatus=" + jobStatus +
                ", condition=" + condition +
                ", totalTime=" + totalTime + " ms" +
                '}';
    }
}
