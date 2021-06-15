package com.bonc.cron.cronTest.jobmanager.quartz;

import com.bonc.cron.cronTest.jobmanager.CronParserUtil;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZhengHang
 * @create 2021-06-11 9:29
 */
public class QuartzManager {
    private final Logger log = LoggerFactory.getLogger(QuartzManager.class);
    @Autowired
    private Scheduler scheduler;
    public void addJob(JobInputInfoVO info){
        JobDetail jobDetail = JobBuilder.newJob(RunningJob.class).withIdentity(info.getJobId(),info.getJobName()).build();
        jobDetail.getJobDataMap().put("jobId",info.getJobId());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(info.getJobId(),info.getJobName()).startNow().
                withSchedule(CronScheduleBuilder.cronSchedule(CronParserUtil.getCron(info))).build();
        try {
            scheduler.scheduleJob(jobDetail,trigger);
            if (!scheduler.isShutdown()){
                scheduler.start();
            }
        } catch (SchedulerException e) {
            log.error(QuartzManager.class.toString() + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 删除一个job
     *
     * @param jobId job的序号
     * @param jobName job的名称
     * @throws SchedulerException
     */
    public void deleteJob(String jobId,String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobId,jobName);
        scheduler.deleteJob(jobKey);
    }

    /**
     * 更新job时间表达式
     *
     * @param info
     * @throws SchedulerException
     */
    public void updateJobCron(JobInputInfoVO info) throws SchedulerException {

        TriggerKey triggerKey = TriggerKey.triggerKey(info.getJobId(), info.getJobName());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(CronParserUtil.getCron(info));

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }
}
