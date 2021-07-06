package com.bonc.cron.cronTest.jobmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-09 14:22
 */
public class JobInfoPO {

    private Integer jobId;

    private String jobName;

    private String jobRemark;

    //标识job是否可用，0为可用，1为不可用
    private Integer jobIsDel;

    private Date jobCreateTime;

    //标识job运行的类型，0为单次job,1为周期性job
    private Integer jobType;

    //标识job的状态，0为关闭，1为开启
    private Integer jobStatus;

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

    public JobInfoPO(int jobId, String jobName, String jobRemark, Date jobCreateTime, int jobType, int jobStatus, String jobQueueName) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobRemark = jobRemark;
        this.jobCreateTime = jobCreateTime;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.jobQueueName = jobQueueName;
    }

    public JobInfoPO(Integer jobId, Integer jobStatus) {
        this.jobId = jobId;
        this.jobStatus = jobStatus;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
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

    public Integer getJobIsDel() {
        return jobIsDel;
    }

    public void setJobIsDel(Integer jobIsDel) {
        this.jobIsDel = jobIsDel;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobQueueName() {
        return jobQueueName;
    }

    public void setJobQueueName(String jobQueueName) {
        this.jobQueueName = jobQueueName;
    }

    @Override
    public String toString() {
        return "JobInfoPO{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobRemark='" + jobRemark + '\'' +
                ", jobIsDel=" + jobIsDel +
                ", jobCreateTime=" +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jobCreateTime) +
                ", jobType=" + jobType +
                ", jobStatus=" + jobStatus +
                ", jobQueueName='" + jobQueueName + '\'' +
                '}';
    }
}
