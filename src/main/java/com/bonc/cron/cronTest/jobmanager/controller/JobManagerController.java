package com.bonc.cron.cronTest.jobmanager.controller;

import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import com.bonc.cron.cronTest.result.JobDetailResult;
import com.bonc.cron.cronTest.result.PageResult;
import com.bonc.cron.cronTest.result.Result;
import com.bonc.cron.cronTest.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-11 16:16
 */
@RestController
@RequestMapping("/jobManger")
public class JobManagerController {

    @Autowired
    JobManagerService jobManagerService;

    @PostMapping("/addJob")
    Result<Boolean> addJob(@RequestBody JobInputInfoVO jobInfo){
        return jobManagerService.addJob(jobInfo);
    }

    @PostMapping("/deleteJob")
    Result<Boolean> deleteJob(int jobId){
        return jobManagerService.deleteJob(jobId);
    }

    @PostMapping("/updateJob")
    Result<Boolean> updateJob(@RequestBody JobInputInfoVO jobInfo){
        return jobManagerService.updateJob(jobInfo);
    }

    @GetMapping("/getJob")
    Result<JobInputInfoVO> getJob(int jobId){
        return jobManagerService.getJob(jobId);
    }

    @GetMapping("/getAllJob")
    Result<PageResult<JobReturnVO>> getAllJobInfo(int type , int status , String condition , int order , int pageNum , int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<JobReturnVO>> allJobInfo = jobManagerService.getAllJobInfo(type, status, condition, order);
        PageInfo<JobReturnVO> resultPageInfo = new PageInfo<>(allJobInfo.getData());
        PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
        return new Result<PageResult<JobReturnVO>>(allJobInfo.getCode(),allJobInfo.getMsg(),pageResult);
    }

    @GetMapping("/getJobHistory")
    Result<PageResult<JobHistoryVO>> getHistoryJob(int jobId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<JobHistoryVO>> historyJob = jobManagerService.getHistoryJob(jobId);
        PageInfo<JobHistoryVO> resultPageInfo = new PageInfo<>(historyJob.getData());
        PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
        return new Result<PageResult<JobHistoryVO>>(historyJob.getCode(),historyJob.getMsg(),pageResult);
    }

    //获取当前job执行详情
    @GetMapping("/getJobDetail")
    Result<JobDetailResult> getJobDetails(int jobId , int pageNum, int pageSize){
        return jobManagerService.getJobDetails(jobId,pageNum,pageSize);
    }

    //获取历史job执行详情
    @GetMapping("/getHistoryDetail")
    Result<JobDetailResult> getJobHistoryDetails(String jobHistoryId, int pageNum, int pageSize){
        return jobManagerService.getJobHistoryDetails(jobHistoryId,pageNum,pageSize);
    }

    //获取子任务详情
    @GetMapping("/getTasks")
    Result<PageResult<SubTaskVO>> getSubTasks(int planHistoryId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<SubTaskVO>> subTasks = jobManagerService.getSubTasks(planHistoryId);
        PageInfo<SubTaskVO> resultPageInfo = new PageInfo<>(subTasks.getData());
        PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
        return new Result<PageResult<SubTaskVO>>(subTasks.getCode(),subTasks.getMsg(),pageResult);
    }

    @PostMapping("/startJob")
    Result<Boolean> startJob(int jobId){
        return jobManagerService.startJob(jobId);
    }

    @PostMapping("/stopJob")
    Result<Boolean> stopJob(int jobId){
        return jobManagerService.stopJob(jobId);
    }

    @PostMapping("/purgeJob")
    Result<Boolean> purge(int jobId){
        return jobManagerService.purge(jobId);
    }
}
