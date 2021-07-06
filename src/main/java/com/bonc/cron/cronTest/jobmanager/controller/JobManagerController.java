package com.bonc.cron.cronTest.jobmanager.controller;

import com.bonc.cron.cronTest.jobmanager.entity.*;
import com.bonc.cron.cronTest.jobmanager.service.JobManagerService;
import com.bonc.cron.cronTest.result.JobDetailResult;
import com.bonc.cron.cronTest.result.PageResult;
import com.bonc.cron.cronTest.result.Result;
import com.bonc.cron.cronTest.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value="增加job接口", notes="添加job信息")
    @ApiImplicitParam(name = "jobInfo", value = "job传入的信息，不需要传入jobId值", required = true, dataType = "JobInputInfoVO")
    @PostMapping("/addJob")
    Result<Boolean> addJob(@RequestBody JobInputInfoVO jobInfo){
        return jobManagerService.addJob(jobInfo);
    }

    @ApiOperation(value = "删除job接口", notes = "删除job信息")
    @ApiImplicitParams(@ApiImplicitParam(name = "jobId",value = "job的序号", required = true, paramType = "query" , dataType = "Int"))
    @PostMapping("/deleteJob")
    Result<Boolean> deleteJob(@RequestParam int jobId){
        return jobManagerService.deleteJob(jobId);
    }

    @ApiOperation(value="更新job接口", notes="修改job信息")
    @ApiImplicitParam(name = "jobInfo", value = "修改后job传入的信息", required = true, dataType = "JobInputInfoVO")
    @PostMapping("/updateJob")
    Result<Boolean> updateJob(@RequestBody JobInputInfoVO jobInfo){
        return jobManagerService.updateJob(jobInfo);
    }

    @ApiOperation(value = "获取单个job接口", notes = "接口用于修改job信息时获取原始数据使用")
    @ApiImplicitParams(@ApiImplicitParam(name = "jobId",value = "job的序号", required = true, paramType = "query" , dataType = "Int"))
    @GetMapping("/getJob")
    Result<JobInputInfoVO> getJob(int jobId){
        return jobManagerService.getJob(jobId);
    }

    @ApiOperation(value = "查询所有job的接口", notes="获取所有的job信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "job类型，0：单次，1：多次，2：全部", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "status", value = "job状态，0为关闭，1为开启，2为失败，3为全部", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "condition", value = "迁移计划的名称（用于模糊查询），不使用时不传", paramType = "query", required = false, dataType = "String"),
            @ApiImplicitParam(name = "order", value = "创建时间排序（0:升序，1:倒序，2：不进行排序）", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageNum", value = "页数(当前页数)", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, paramType = "query", dataType = "Int")
    })
    @GetMapping("/getAllJob")
    Result<PageResult<JobReturnVO>> getAllJobInfo(int type , int status , String condition , int order , int pageNum , int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<JobReturnVO>> allJobInfo = jobManagerService.getAllJobInfo(type, status, condition, order);
        PageInfo<JobReturnVO> resultPageInfo = new PageInfo<>(allJobInfo.getData());
        PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
        return new Result<>(allJobInfo.getCode(),allJobInfo.getMsg(),pageResult);
    }

    @ApiOperation(value = "查询job历史信息的接口", notes="获取所有的job执行的历史信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobId", value = "job序号", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageNum", value = "页数(当前页数)", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, paramType = "query", dataType = "Int")
    })
    @GetMapping("/getJobHistory")
    Result<PageResult<JobHistoryVO>> getHistoryJob(int jobId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<JobHistoryVO>> historyJob = jobManagerService.getHistoryJob(jobId);
        if (historyJob.getCode() == 200) {
            PageInfo<JobHistoryVO> resultPageInfo = new PageInfo<>(historyJob.getData());
            PageResult<JobHistoryVO> pageResult = PageUtils.getPageResult(resultPageInfo);
            return new Result<>(historyJob.getCode(), historyJob.getMsg(), pageResult);
        }else {
            return new Result<>(historyJob.getCode(), historyJob.getMsg(),null);
        }
    }

    @ApiOperation(value = "查询当前job执行详情", notes="获取当前job执行详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobId", value = "job序号", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageNum", value = "页数(当前页数)", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, paramType = "query", dataType = "Int")
    })
    //获取当前job执行详情
    @GetMapping("/getJobDetail")
    Result<JobDetailResult> getJobDetails(int jobId , int pageNum, int pageSize){
        return jobManagerService.getJobDetails(jobId,pageNum,pageSize);
    }

    @ApiOperation(value = "查询历史job执行详情", notes="获取历史job执行详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobHistoryId", value = "历史job序号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数(当前页数)", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, paramType = "query", dataType = "Int")
    })
    //获取历史job执行详情
    @GetMapping("/getHistoryDetail")
    Result<JobDetailResult> getJobHistoryDetails(String jobHistoryId, int pageNum, int pageSize){
        return jobManagerService.getJobHistoryDetails(jobHistoryId,pageNum,pageSize);
    }

    @ApiOperation(value = "查询子任务job执行详情", notes="在详请页面使用，获取子任务执行的情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "planHistoryId", value = "历史plan的序号", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageNum", value = "页数(当前页数)", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "pageSize", value = "页面条数", required = true, paramType = "query", dataType = "Int"),
            @ApiImplicitParam(name = "runStatus", value = "子计划运行状态，0：运行中，1：成功，2:失败，3：队列中，4：全部", required = true, paramType = "query", dataType = "Int")
    })
    //获取子任务详情
    @GetMapping("/getTasks")
    Result<PageResult<SubTaskVO>> getSubTasks(int planHistoryId, int pageNum, int pageSize , int runStatus){
        PageHelper.startPage(pageNum,pageSize);
        Result<List<SubTaskVO>> subTasks = jobManagerService.getSubTasks(planHistoryId,runStatus);
        if (subTasks.getCode() == 200) {
            PageInfo<SubTaskVO> resultPageInfo = new PageInfo<>(subTasks.getData());
            PageResult pageResult = PageUtils.getPageResult(resultPageInfo);
            return new Result<>(subTasks.getCode(), subTasks.getMsg(), pageResult);
        }{
            return new Result<>(subTasks.getCode(), subTasks.getMsg(),null);
        }
    }

    @ApiOperation(value = "启动job接口", notes = "启动一个job")
    @ApiImplicitParams(@ApiImplicitParam(name = "jobId",value = "job的序号", required = true, paramType = "query" , dataType = "Int"))
    @PostMapping("/startJob")
    Result<Boolean> startJob(int jobId){
        return jobManagerService.startJob(jobId);
    }

    @ApiOperation(value = "停止job接口", notes = "停止一个job")
    @ApiImplicitParams(@ApiImplicitParam(name = "jobId",value = "job的序号", required = true, paramType = "query" , dataType = "Int"))
    @PostMapping("/stopJob")
    Result<Boolean> stopJob(int jobId){
        return jobManagerService.stopJob(jobId);
    }

    @ApiOperation(value = "清理job接口", notes = "清除job安全模式下保存的原始数据")
    @ApiImplicitParams(@ApiImplicitParam(name = "jobId",value = "job的序号", required = true, paramType = "query" , dataType = "Int"))
    @PostMapping("/purgeJob")
    Result<Boolean> purge(int jobId){
        return jobManagerService.purge(jobId);
    }
}
