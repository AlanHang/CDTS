package com.bonc.cron.cronTest.test;

import org.quartz.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-08 17:06
 */
//@DisallowConcurrentExecution //作业不并发
@Component
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JobDataMap jobDataMap = arg0.getJobDetail().getJobDataMap();
        System.out.println("任务序号:"+jobDataMap.getString("id")+" 任务名称："+jobDataMap.getString("jobName")+"  "+ sdf.format(new Date()) );

    }

}