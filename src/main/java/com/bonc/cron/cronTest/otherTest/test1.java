package com.bonc.cron.cronTest.otherTest;

import com.bonc.cron.cronTest.ceainject.entity.CEACluster;
import com.bonc.cron.cronTest.jobmanager.CronParserUtil;
import com.bonc.cron.cronTest.jobmanager.entity.CycleRules;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;
import com.bonc.cron.cronTest.jobmanager.quartz.QuartzManager;

import java.util.Date;

/**
 * @author ZhengHang
 * @create 2021-06-10 15:57
 */
public class test1 {
    public static void main(String[] args) {
        CEACluster c = new CEACluster();
        c.setCeaId(1);
        c.setClusterId(2);
        System.out.println(c.getCeaId() + "  " + c.getClusterId());
        System.out.println(QuartzManager.class.toString());
        JobInputInfoVO info = new JobInputInfoVO();
        info.setJobType(1);
        CycleRules rules = new CycleRules();
        rules.startTime = new Date();
        rules.isEveryDay = true;
        info.setRules(rules);
        System.out.println(CronParserUtil.getCron(info));
    }
}
