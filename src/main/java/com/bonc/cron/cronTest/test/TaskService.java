package com.bonc.cron.cronTest.test;

import org.quartz.SchedulerException;

/**
 * @author ZhengHang
 * @create 2021-06-08 17:02
 */
public interface TaskService {

    TaskDO get(Long id);

    DataGridResult list(TaskQuery query);

    int save(TaskDO taskScheduleJob);

    int update(TaskDO taskScheduleJob);

    int remove(Long id);

    int removeBatch(Long[] ids);

    void initSchedule() throws SchedulerException;

    void changeStatus(Long jobId, String jobStatus) throws SchedulerException;

    void updateCron(Long jobId) throws SchedulerException;

    void run(TaskDO scheduleJob) throws SchedulerException;
}