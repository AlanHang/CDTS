package com.bonc.cron.cronTest;

import com.bonc.cron.cronTest.jobmanager.dao.JobDao;
import com.bonc.cron.cronTest.jobmanager.dao.JobDetailsDao;
import com.bonc.cron.cronTest.jobmanager.dao.JobStrategyDao;
import com.bonc.cron.cronTest.jobmanager.dao.PlanOrderDao;
import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CornTestApplicationTests {

	@Autowired
	JobDao jobDao;

	@Autowired
	JobDetailsDao jobDetailsDao;

	@Autowired
	JobStrategyDao jobStrategyDao;

	@Autowired
	JobManagerService jobManagerService;

	@Autowired
	PlanOrderDao planOrderDao;

	@Test
	void contextLoads() {
		JobInfoPO jobInfoPO = new JobInfoPO(1,"测试名称","测试",0,
				new Date(),1,0,"测试");
//		jobDao.addJobInfo(jobInfoPO);
//		System.out.println(jobDao.selectOneJobInfo(1));

		List<JobStrategyInfoPO> strategyList =
				Arrays.asList(new JobStrategyInfoPO(1, StrategyKey.IGNORE_FAILS.name(), "true"),
				new JobStrategyInfoPO(1, StrategyKey.IS_FREEZE.name(),"true"),
				new JobStrategyInfoPO(1, StrategyKey.IS_RUN_FAILS.name(),"true"),
						new JobStrategyInfoPO(1, StrategyKey.IS_SAFE.name(),"true"));

//		jobStrategyDao.addJobStrategy(strategyList);

//		for (JobStrategyInfoPO jobStrategyInfoPO : jobStrategyDao.selectAllJobStrategy(1)) {
//			System.out.println(jobStrategyInfoPO);
//		}
//
//		System.out.println(jobStrategyDao.selectOneJobStrategy(1,StrategyKey.IGNORE_FAILS.name()));

//		for (JobReturnPO infoPO : jobDao.selectAllJobInfo()) {
//			System.out.println(infoPO);
//		}
//
		for (JobReturnVO datum : jobManagerService.getAllJobInfo(1,3,null,1).getData()) {
			System.out.println(datum);
		}
//
//		for (JobHistoryVO datum : jobManagerService.getHistoryJob(1).getData()) {
//			System.out.println(datum);
//		}

//		System.out.println(planOrderDao.addPlanOrderByJob(1, Arrays.asList(2, 4, 3, 5)));

//		System.out.println(planOrderDao.deletePlanOrderByJobId(1));

//		System.out.println(planOrderDao.selectAllByJobId(1));


//		System.out.println(jobManagerService.getJobDetails(1));


	}


}
