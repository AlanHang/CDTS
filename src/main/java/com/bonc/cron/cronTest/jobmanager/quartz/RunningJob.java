package com.bonc.cron.cronTest.jobmanager.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZhengHang
 * @create 2021-06-10 17:18
 */
public class RunningJob implements Job {
    private final Logger log = LoggerFactory.getLogger(RunningJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        log.info("开始执行Job,jobId = "+ jobDataMap.getString("jobId"));
    }
}
