package com.bonc.cron.cronTest.jobmanager.controller;

import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.result.PageResult;
import com.bonc.cron.cronTest.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-11 16:16
 */
@RestController
@RequestMapping("/jobManger")
public class JobManagerController {
    @PostMapping("/addJob")
    Result<Boolean> addJob(@RequestBody JobInputInfoVO jobInfo){
        System.out.println("进入add");
        System.out.println(jobInfo);
        System.out.println("显示时间："+jobInfo.getRules().startTime);
        return null;
    }
    @PostMapping("/deleteJob")
    Result<Boolean> deleteJob(int jobId){
        return null;
    }
    @PostMapping("/updateJob")
    Result<Boolean> updateJob(JobInputInfoVO jobInfo){
        return null;
    }
    @GetMapping("/getJob")
    Result<JobInputInfoVO> getJob(int jobId){
        return new Result<>(200,"success",new JobInputInfoVO(jobId));
    }
    @GetMapping("/getAllJob")
    Result<PageResult<JobInfoVO>> getAllJobInfo(int type , int status , String condition , int order , int pageNum , int pageSize){
        PageResult pageResult = new PageResult(1,2,20,10);
        pageResult.setContent(Arrays.asList(new JobInfoVO(0),new JobInfoVO(1)));
        return new Result<PageResult<JobInfoVO>>(200,"success",pageResult);
    }
    @GetMapping("/getJobHistory")
    Result<PageResult<JobHistoryVO>> getHistoryJob(int jobId,int pageSize , int page){
        PageResult pageResult = new PageResult(1,2,20,10);
        pageResult.setContent(Arrays.asList(new JobHistoryVO("0dsafc"),new JobHistoryVO("1dafg")));
        return new Result<PageResult<JobHistoryVO>>(200,"success",pageResult);
    }
    //获取当前job执行详情
    @GetMapping("/getJobDetail")
    Result<PageResult<JobDetailsVO>> getJobDetails(int jobId , int pageSize , int page){
        PageResult pageResult = new PageResult(1,2,20,10);
        pageResult.setContent(Arrays.asList(new JobDetailsVO(1)));
        return new Result<PageResult<JobDetailsVO>>(200,"success",pageResult);
    }
    //获取历史job执行详情
    @GetMapping("/getHistoryDetail")
    Result<PageResult<JobDetailsVO>> getJobHistoryDetails(String jobHistoryId,int pageSize , int page){
        return null;
    }

    //获取子任务详情
    @GetMapping("/getTasks")
    Result<PageResult<SubTaskVO>> getSubTasks(String historyId , int planHistoryId, int pageSize , int page){
        PageResult pageResult = new PageResult(1,2,20,10);
        pageResult.setContent(Arrays.asList(new SubTaskVO("1"),new SubTaskVO("2")));
        return new Result<PageResult<SubTaskVO>>(200,"success",pageResult);
    }

    @PostMapping("/startJob")
    Result<Boolean> startJob(int jobId){
        return null;
    }
    @PostMapping("/stopJob")
    Result<Boolean> stopJob(int jobId){
        return null;
    }
    @PostMapping("/purgeJob")
    Result<Boolean> purge(int jobId){
        return null;
    }
}
