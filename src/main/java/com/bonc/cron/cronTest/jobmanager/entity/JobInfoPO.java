package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-09 14:22
 */
public class JobInfoPO {
    private int jobId;
    private String jobName;
    private String jobRemark;
    //标识job是否可用，0为可用，1为不可用
    private int jobIsDel;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date jobCreateTime;
    //标识job运行的类型，0为单次job,1为周期性job
    private int jobType;
    //标识job的状态，0为关闭，1为开启
    private int jobStatus;
    //执行队列的名称
    private String jobQueueName;

    public JobInfoPO() {
    }

    public JobInfoPO(int jobId, String jobName, String jobRemark, int jobIsDel, Date jobCreateTime, int jobType, int jobStatus, String jobQueueName) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobIsDel = jobIsDel;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.jobQueueName = jobQueueName;
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

    public int getJobIsDel() {
        return jobIsDel;
    }

    public void setJobIsDel(int jobIsDel) {
        this.jobIsDel = jobIsDel;
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

    public String getJobQueueName() {
        return jobQueueName;
    }

    public void setJobQueueName(String jobQueueName) {
        this.jobQueueName = jobQueueName;
    }
}
