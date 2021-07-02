package com.bonc.cron.cronTest.jobmanager.quartz;

import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import com.bonc.cron.cronTest.test.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZhengHang
 * @create 2021-06-11 16:10
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    JobManagerService jobManagerService;

    @Override
    public void run(String... arg0) throws Exception {
        try {
            jobManagerService.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
