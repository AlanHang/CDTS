package com.bonc.cron.cronTest.jobmanager.controller;

import com.bonc.cron.cronTest.jobmanager.entity.JobDetailsVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobHistoryVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInfoVO;
import com.bonc.cron.cronTest.jobmanager.entity.JobInputInfoVO;
import com.bonc.cron.cronTest.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-11 16:16
 */
@Controller
@RequestMapping("/jobManger")
public class JobManagerController {
    @PostMapping("/addJob")
    Result<Boolean> addJob(JobInputInfoVO jobInfo){
        return null;
    }
    @PostMapping("/deleteJob")
    Result<Boolean> deleteJob(String jobId){
        return null;
    }
    @PostMapping("/updateJob")
    Result<Boolean> updateJob(JobInputInfoVO jobInfo){
        return null;
    }
    @GetMapping("/getJob")
    Result<JobInputInfoVO> getJob(String jobId){
        return null;
    }
    @GetMapping("/getAllJob")
    Result<List<JobInfoVO>> getAllJobInfo(String conditionKey, String condition,int pageSize , int page){
        return null;
    }
    @GetMapping("/getJobHistory")
    Result<List<JobHistoryVO>> getHistoryJob(String jobId,int pageSize , int page){
        return null;
    }
    //获取当前job执行详情
    @GetMapping("/getJobDetail")
    Result<List<JobDetailsVO>> getJobDetails(String jobId , int pageSize , int page){
        return null;
    }
    //获取历史job执行详情
    @GetMapping("/getHistoryDetail")
    Result<List<JobDetailsVO>> getJobHistoryDetails(int jobHistoryId,int pageSize , int page){
        return null;
    }
    @PostMapping("/startJob")
    Result<Boolean> startJob(String jobId){
        return null;
    }
    @PostMapping("/stopJob")
    Result<Boolean> stopJob(String jobId){
        return null;
    }
    @PostMapping("/purgeJob")
    Result<Boolean> purge(String jobId){
        return null;
    }
}
