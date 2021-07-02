package com.bonc.cron.cronTest.jobmanager.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhengHang
 * @create 2021-06-11 9:29
 */
@Service
public class QuartzManager {
    private final Logger log = LoggerFactory.getLogger(QuartzManager.class);

    @Autowired
    private Scheduler scheduler;

    /**
     * 添加一个job
     *
     * @param jobId job的序号
     * @param cron  job的cron表达式
     * @throws SchedulerException
     */
    public void addJob(int jobId, String cron) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(RunningJob.class).withIdentity(String.valueOf(jobId), "jobManager").build();
        jobDetail.getJobDataMap().put("jobId", String.valueOf(jobId));
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(String.valueOf(jobId), "jobManager").startNow().
                withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown()) {
            scheduler.start();
//            pauseJob(jobId);
        }
    }

    /**
     * 删除一个job
     *
     * @param jobId job的序号
     * @throws SchedulerException
     */
    public void deleteJob(int jobId) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(String.valueOf(jobId), "jobManager");
        scheduler.deleteJob(jobKey);
    }

    /**
     * 暂停一个job
     *
     * @param jobId job的序号
     * @throws SchedulerException
     */
    public void pauseJob(int jobId) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(String.valueOf(jobId), "jobManager");
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复一个job（启动停止的job）
     *
     * @param jobId job的序号
     * @throws SchedulerException
     */
    public void resumeJob(int jobId) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(String.valueOf(jobId), "jobManager");
        scheduler.resumeJob(jobKey);
    }

    /**
     * 更新job时间表达式
     *
     * @param jobId job的序号
     * @param cron  新的表达式
     * @throws SchedulerException
     */
    public void updateJobCron(int jobId, String cron) throws SchedulerException {

        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(jobId), "jobManager");

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }
}
