package com.bonc.cron.cronTest.jobmanager.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bonc.cron.cronTest.jobmanager.dao.*;
import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.jobmanager.quartz.QuartzManager;
import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import com.bonc.cron.cronTest.result.CodeMessage;
import com.bonc.cron.cronTest.result.JobDetailResult;
import com.bonc.cron.cronTest.result.PageResult;
import com.bonc.cron.cronTest.result.Result;
import com.bonc.cron.cronTest.utils.CronParserUtil;
import com.bonc.cron.cronTest.utils.JavaBeanUtil;
import com.bonc.cron.cronTest.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ZhengHang
 * @create 2021-06-10 17:16
 */
@Service
public class JobManagerImpl implements JobManagerService {

    private static Logger log = LoggerFactory.getLogger(JobManagerImpl.class);

    @Autowired
    JobDao jobDao;

    @Autowired
    JobDetailsDao jobDetailsDao;

    @Autowired
    JobStrategyDao jobStrategyDao;

    @Autowired
    PlanOrderDao planOrderDao;

    @Autowired
    SubTaskDao subTaskDao;

    @Autowired(required = false)
    QuartzManager quartzManager;

    @Transactional
    @Override
    public Result<Boolean> addJob(JobInputInfoVO jobInfo) {
        JobInfoPO jobInfoPO = JavaBeanUtil.copyBean(jobInfo, JobInfoPO.class);
        jobInfoPO.setJobIsDel(0);
        jobInfoPO.setJobStatus(1);
        jobInfoPO.setJobCreateTime(new Date());
        int flag = jobDao.addJobInfo(jobInfoPO);
        if (flag > 0) {
            jobInfo.setJobId(jobInfoPO.getJobId());
        } else {
            return new Result<>(400, "fail to add jobInfo into dataBase", false);
        }
        //添加planOrder
        planOrderDao.addPlanOrderByJob(jobInfo.getJobId(), jobInfo.getPlansId());

        List<JobStrategyInfoPO> strategyList = new ArrayList<>(7);
        //添加cron表达式
        String cron = CronParserUtil.getCron(jobInfo);
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.PLAN_CYCLETIMES.name(), cron));
        //添加子计划并行度
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.SUB_PLAN_AMOUTS.name(), String.valueOf(jobInfo.getSubPlanAmounts())));
        //添加是否忽略失败
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IGNORE_FAILS.name(), String.valueOf(jobInfo.isIgnoreFails())));
        //添加是否采用安全模式
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_SAFE.name(), String.valueOf(jobInfo.isSafe())));
        //添加是否冻结集群
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_FREEZE.name(), String.valueOf(jobInfo.isFreeze())));
        //添加重试次数
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.RETRY_COUNT.name(), String.valueOf(jobInfo.getRetryCount())));
        //添加是否只运行失败任务
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_RUN_FAILS.name(), String.valueOf(jobInfo.isRunFails())));

        flag = jobStrategyDao.addJobStrategy(strategyList);
        if (flag == 7) {
            try {
                quartzManager.addJob(jobInfo.getJobId(), cron);
            } catch (SchedulerException e) {
                log.error("add job to quartz error:" + e.getMessage());
                e.printStackTrace();
                return new Result<>(400, "add job to quartz error:" + e.getMessage(), false);
            }
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), true);
        } else {
            return new Result<>(400, "fail to add jobStrategy into dataBase", false);
        }
    }

    @Override
    public Result<Boolean> deleteJob(int jobId) {
        int flag = jobDao.deleteJobInfo(jobId);
        planOrderDao.deletePlanOrderByJobId(jobId);
        if (flag > 0) {
            try {
                quartzManager.deleteJob(jobId);
            } catch (SchedulerException e) {
                log.error("delete job to quartz error:" + e.getMessage());
                e.printStackTrace();
                return new Result<>(400, "delete job to quartz error:" + e.getMessage(), false);
            }
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), true);
        } else {
            return new Result<>(400, "fail to delete jobInfo from dataBase", false);
        }
    }

    @Transactional
    @Override
    public Result<Boolean> updateJob(JobInputInfoVO jobInfo) {
        JobInfoPO jobInfoPO = JavaBeanUtil.copyBean(jobInfo, JobInfoPO.class);
        int flag = jobDao.updateJobInfo(jobInfoPO);
        if (flag == 0) {
            return new Result<>(400, "fail to update jobInfo into dataBase", false);
        }
        //修改planOrder
        planOrderDao.deletePlanOrderByJobId(jobInfo.getJobId());
        planOrderDao.addPlanOrderByJob(jobInfo.getJobId(), jobInfo.getPlansId());

        List<JobStrategyInfoPO> strategyList = new ArrayList<>(7);
        //添加cron表达式
        String cron = CronParserUtil.getCron(jobInfo);
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.PLAN_CYCLETIMES.name(), cron));
        //添加子计划并行度
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.SUB_PLAN_AMOUTS.name(), String.valueOf(jobInfo.getSubPlanAmounts())));
        //添加是否忽略失败
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IGNORE_FAILS.name(), String.valueOf(jobInfo.isIgnoreFails())));
        //添加是否采用安全模式
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_SAFE.name(), String.valueOf(jobInfo.isSafe())));
        //添加是否冻结集群
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_FREEZE.name(), String.valueOf(jobInfo.isFreeze())));
        //添加重试次数
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.RETRY_COUNT.name(), String.valueOf(jobInfo.getRetryCount())));
        //添加是否只运行失败任务
        strategyList.add(new JobStrategyInfoPO(jobInfo.getJobId(), StrategyKey.IS_RUN_FAILS.name(), String.valueOf(jobInfo.isRunFails())));

        flag = jobStrategyDao.updateJobStrategy(strategyList);
        if (flag == 7) {
//            try {
//                quartzManager.updateJobCron(jobInfo.getJobId(), cron);
//            } catch (SchedulerException e) {
//                log.error("update job cron error:" + e.getMessage());
//                e.printStackTrace();
//                return new Result<>(400, "update job cron error:" + e.getMessage(), false);
//            }
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), true);
        } else {
            return new Result<>(400, "fail to update jobStrategy into dataBase", false);
        }
    }

    @Override
    public Result<JobInputInfoVO> getJob(int jobId) {
        List<JobInfoPO> jobInfoPOS = jobDao.selectOneJobInfo(jobId);
        if (jobInfoPOS == null && jobInfoPOS.size() == 0) {
            return new Result<>(400, "fail to find jobInfo", null);
        } else {
            JobInputInfoVO result = JavaBeanUtil.copyBean(jobInfoPOS.get(0), JobInputInfoVO.class);
            //设置plan队列
            result.setPlansId(planOrderDao.selectAllByJobId(jobId));
            List<JobStrategyInfoPO> strategyList = jobStrategyDao.selectAllJobStrategy(jobId);
            Map<String, String> strategyMap = new HashMap<>();
            for (JobStrategyInfoPO jobStrategyInfoPO : strategyList) {
                strategyMap.put(jobStrategyInfoPO.getJobStrategyKey(), jobStrategyInfoPO.getJobStrategyValue());
            }

            //添加循环策略
            result.setRules(CronParserUtil.parseCron(strategyMap.get(StrategyKey.PLAN_CYCLETIMES.name()), result.getJobType()));
            //添加子计划并行度
            result.setSubPlanAmounts(Integer.parseInt(strategyMap.get(StrategyKey.SUB_PLAN_AMOUTS.name())));
            //添加是否忽略失败
            result.setIgnoreFails(Boolean.parseBoolean(strategyMap.get(StrategyKey.IGNORE_FAILS.name())));
            //添加是否采用安全模式
            result.setIgnoreFails(Boolean.parseBoolean(strategyMap.get(StrategyKey.IS_SAFE.name())));
            //添加是否冻结集群
            result.setIgnoreFails(Boolean.parseBoolean(strategyMap.get(StrategyKey.IS_FREEZE.name())));
            //添加失败重试次数
            result.setSubPlanAmounts(Integer.parseInt(strategyMap.get(StrategyKey.RETRY_COUNT.name())));
            //添加是否只运行失败任务
            result.setIgnoreFails(Boolean.parseBoolean(strategyMap.get(StrategyKey.IS_RUN_FAILS.name())));

            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), result);
        }
    }

    @Override
    public Result<List<JobReturnVO>> getAllJobInfo(int type , int status , String condition , int order) {
        List<JobReturnPO> jobReturnPOS = jobDao.selectAllReturnJobInfo(type,status,condition,order);
        if (jobReturnPOS == null && jobReturnPOS.size() == 0) {
            return new Result<>(400, "fail to find jobInfo", null);
        } else {
            List<JobReturnVO> result = new ArrayList<>(jobReturnPOS.size());
            for (JobReturnPO jobReturnPO : jobReturnPOS) {
                JobReturnVO jobReturnVO = JavaBeanUtil.copyBean(jobReturnPO, JobReturnVO.class);
                if (jobReturnPO.getStartTime() != null) {
                    jobReturnVO.setStartTime(new SimpleDateFormat("EEEE HH:mm:ss").format(jobReturnPO.getStartTime()));
                }
                if (jobReturnPO.getCompleteDetail() != null) {
                    JSONObject completeDetail = JSONObject.parseObject(jobReturnPO.getCompleteDetail());
                    jobReturnVO.setCondition(new ExecuteCondition(completeDetail.getInteger("all_count"),
                            completeDetail.getInteger("success_count") + completeDetail.getInteger("error_count"),
                            completeDetail.getInteger("success_count"), completeDetail.getInteger("error_count")));
                    jobReturnVO.setTotalTime(jobReturnPO.getEndTime().getTime() - jobReturnPO.getStartTime().getTime());
                }
                result.add(jobReturnVO);
            }
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), result);
        }
    }

    @Override
    public Result<List<JobHistoryVO>> getHistoryJob(int jobId) {
        List<JobHistoryPO> jobHistoryPOS = jobDetailsDao.selectJobHistory(jobId);
        if (jobHistoryPOS != null && jobHistoryPOS.size() > 0) {
            List<JobHistoryVO> result = new ArrayList<>(jobHistoryPOS.size());
            for (JobHistoryPO jobHistoryPO : jobHistoryPOS) {
                JobHistoryVO jobHistoryVO = JavaBeanUtil.copyBean(jobHistoryPO, JobHistoryVO.class);
                if (jobHistoryPO.getCompleteDetail() != null) {
                    JSONObject completeDetail = JSONObject.parseObject(jobHistoryPO.getCompleteDetail());
                    jobHistoryVO.setCondition(new ExecuteCondition(completeDetail.getInteger("all_count"),
                            completeDetail.getInteger("success_count") + completeDetail.getInteger("error_count"),
                            completeDetail.getInteger("success_count"), completeDetail.getInteger("error_count")));
                    result.add(jobHistoryVO);
                }
            }
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), result);
        } else {
            return new Result<>(400, "fail to find jobHistoryInfo", null);
        }
    }

    @Override
    public Result<JobDetailResult> getJobDetails(int jobId, int pageNum, int pageSize) {
        String historyId = jobDetailsDao.selectJobHistoryId(jobId);
        if (historyId == null || historyId.replaceAll(" ", "").equals("")) {
            return new Result<>(400, "fail to find historyId using jobId , jobId = " + jobId, null);
        } else {
            JobDetailsVO result = new JobDetailsVO();
            result.setHistoryId(historyId);
            List<PlanVO> planVOS = jobDetailsDao.selectPlanQueue(historyId);
            if (planVOS == null || planVOS.size() <= 0) {
                return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), null);
            }
            result.setPlans(planVOS);
            PageHelper.startPage(pageNum,pageSize);
            List<SubTaskVO> subTaskResult = getSubTasks(planVOS.get(0).getPlanHisId()).getData();
            PageInfo<SubTaskVO> resultPageInfo = new PageInfo<>(subTaskResult);
            PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
            result.setTasks(pageResult.getContent());
            JobDetailResult resultAfterPage = new JobDetailResult(pageResult.getPageNum(),pageResult.getPageSize(),pageResult.getTotalSize(),
                    pageResult.getTotalPages(),result);
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), resultAfterPage);
        }
    }

    @Override
    public Result<JobDetailResult> getJobHistoryDetails(String jobHistoryId , int pageNum, int pageSize) {
        JobDetailsVO result = new JobDetailsVO();
        result.setHistoryId(jobHistoryId);
        List<PlanVO> planVOS = jobDetailsDao.selectPlanQueue(jobHistoryId);
        if (planVOS == null || planVOS.size() <= 0) {
            return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), null);
        }
        result.setPlans(planVOS);
        PageHelper.startPage(pageNum,pageSize);
        List<SubTaskVO> subTaskResult = getSubTasks(planVOS.get(0).getPlanHisId()).getData();
        PageInfo<SubTaskVO> resultPageInfo = new PageInfo<>(subTaskResult);
        PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
        result.setTasks(pageResult.getContent());
        JobDetailResult resultAfterPage = new JobDetailResult(pageResult.getPageNum(),pageResult.getPageSize(),pageResult.getTotalSize(),
                pageResult.getTotalPages(),result);
        return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), resultAfterPage);
    }

    @Override
    public Result<List<SubTaskVO>> getSubTasks(int planHistoryId) {
        List<SubTaskPO> subTaskPOS = subTaskDao.selectSubTasks(planHistoryId);
        List<SubTaskVO> subTaskResult = new ArrayList<>(subTaskPOS.size());
        for (SubTaskPO subTaskPO : subTaskPOS) {
            SubTaskVO subTaskVO = JavaBeanUtil.copyBean(subTaskPO,SubTaskVO.class);
            if (subTaskPO.getCompleteDetail() != null) {
                JSONObject completeDetail = JSONObject.parseObject(subTaskPO.getCompleteDetail());
                subTaskVO.setCondition(new ExecuteCondition(completeDetail.getInteger("all_count"),
                        completeDetail.getInteger("success_count") + completeDetail.getInteger("error_count"),
                        completeDetail.getInteger("success_count"), completeDetail.getInteger("error_count")));
            }
            subTaskResult.add(subTaskVO);
        }
        return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(),subTaskResult);
    }

    @Override
    public Result<Boolean> startJob(int jobId) {
        try {
            quartzManager.resumeJob(jobId);
        } catch (SchedulerException e) {
            log.error("start job error:" + e.getMessage());
            e.printStackTrace();
            return new Result<>(400, "start job error:" + e.getMessage(), false);
        }
        return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), true);
    }

    @Override
    public Result<Boolean> stopJob(int jobId) {
        try {
            quartzManager.pauseJob(jobId);
        } catch (SchedulerException e) {
            log.error("stop job error:" + e.getMessage());
            e.printStackTrace();
            return new Result<>(400, "stop job error:" + e.getMessage(), false);
        }
        return new Result<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMsg(), true);
    }

    @Override
    public Result<Boolean> purge(int jobId) {
        return null;
    }


    @Override
    public void initSchedule() throws SchedulerException {
        List<JobInfoPO> jobInfoPOS = jobDao.selectAllJobInfo();
        for (JobInfoPO jobInfoPO : jobInfoPOS) {
            if (jobInfoPO.getJobStatus() == 1) {
                String cron = jobStrategyDao.selectOneJobStrategy(jobInfoPO.getJobId(), StrategyKey.PLAN_CYCLETIMES.name());
                quartzManager.addJob(jobInfoPO.getJobId(), cron);
            }
        }
    }
}
