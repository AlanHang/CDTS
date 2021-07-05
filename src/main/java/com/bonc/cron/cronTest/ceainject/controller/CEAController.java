package com.bonc.cron.cronTest.ceainject.controller;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import com.bonc.cron.cronTest.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 15:31
 */
@RestController
@RequestMapping("/ceaInject")
public class CEAController {

    @Autowired
    CEAService ceaService;

    @ApiOperation(value="注入CEA集群的接口", notes="增加CEA信息")
    @ApiImplicitParam(name = "info", value = "CEA传入的信息，不需要传入id值", required = true, dataType = "CEAInfoVO")
    @PostMapping("/add")
    public Result<Boolean> addCEA(@RequestBody CEAInfoVO info) {
        return ceaService.addCEA(info);
    }

    @ApiOperation(value="删除CEA集群的接口", notes="删除CEA信息，有引用时无法删除")
    @PostMapping("/delete")
    public Result<Boolean>  deleteCEA(@RequestParam @ApiParam(name="ceaId",value="cea序号",required=true) int ceaId) {
        return ceaService.deleteCEA(ceaId);
    }

    @ApiOperation(value="修改CEA集群的接口", notes="修改CEA信息，如果修改ip会检查是否有引用")
    @ApiImplicitParam(name = "info", value = "CEA传入的信息", required = true, dataType = "CEAInfoVO")
    @PostMapping("/edit")
    public Result<Boolean> editCEA(@RequestBody CEAInfoVO info) {
        return ceaService.editCEA(info);
    }

    @ApiOperation(value="刷新CEA集群的接口", notes="刷新CEA，重新获取行云信息")
    @ApiImplicitParam(name = "ceaIds", value = "需要刷新的CEA序号数组", required = true, dataType = "List")
    @PostMapping("/refresh")
    public Result<Boolean> refresh(@RequestBody List<Integer> ceaIds) {
        return ceaService.refresh(ceaIds);
    }

    @ApiOperation(value="获取CEA信息的接口", notes="展示所有已注入的CEA信息")
    @GetMapping("/getAllCEA")
    public Result<List<CEAInfoVO>> getAllCEA() {
        return ceaService.getAllCEA();
    }

    @ApiOperation(value="获取单个CEA信息的接口", notes="供修改时获取原始信息时使用")
    @GetMapping("/getOneCEA")
    public Result<CEAInfoVO> getOneCEA(@RequestParam @ApiParam(name="ceaId",value="cea序号",required=true) int ceaId) {
        return ceaService.getOneCEA(ceaId);
    }

    @PostMapping("/test")
    public String testJson(){
        return "[{'clusterId':'155','clusterName':'1sfgh','zookeeperAddress':'1245sdf','xcloudClusterName':'sfawegta','xcloudRootName':'sfag','hadoopUser':'dage','kerbPrincipal':'sdgag','kerbKeytabFile':'sdga','currentVersion':'sdfg'}," +
                "{'clusterId':'158','clusterName':'sdf22','zookeeperAddress':'1245sdf','xcloudClusterName':'sfawegta','xcloudRootName':'sfag','hadoopUser':'dage','kerbPrincipal':'sdgag','kerbKeytabFile':'sdga','currentVersion':'sdfg','krb5Conf':'sdgg'}" +
                "]";
    }

    @PostMapping("/test1")
    public String test1Json(){
        return "[{'clusterId':'155','clusterName':'refresh','zookeeperAddress':'172.0.0.1','xcloudClusterName':'sfawegta','xcloudRootName':'sfag','hadoopUser':'dage','kerbPrincipal':'sdgag','kerbKeytabFile':'sdga','currentVersion':'sdfg'}," +
                "{'clusterId':'156','clusterName':'refresh','zookeeperAddress':'172.0.0.2','xcloudClusterName':'sfawegta','xcloudRootName':'sfag','hadoopUser':'dage','kerbPrincipal':'sdgag','kerbKeytabFile':'sdga','currentVersion':'sdfg','krb5Conf':'sdgg'}" +
                "{'clusterId':'157','clusterName':'refresh','zookeeperAddress':'172.0.0.2','xcloudClusterName':'sfawegta','xcloudRootName':'sfag','hadoopUser':'dage','kerbPrincipal':'sdgag','kerbKeytabFile':'sdga','currentVersion':'sdfg','krb5Conf':'sdgg'}" +
                "]";
    }

}
