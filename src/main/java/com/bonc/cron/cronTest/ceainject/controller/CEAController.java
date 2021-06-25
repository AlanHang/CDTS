package com.bonc.cron.cronTest.ceainject.controller;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import com.bonc.cron.cronTest.result.Result;
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

    @PostMapping("/add")
    public Result<Boolean> addCEA(CEAInfoVO info) {
        return ceaService.addCEA(info);
    }

    @PostMapping("/delete")
    public Result<Boolean>  deleteCEA(int ceaId) {
        return ceaService.deleteCEA(ceaId);
    }

    @PostMapping("/edit")
    public Result<Boolean> editCEA(CEAInfoVO info) {
        return ceaService.editCEA(info);
    }

    @PostMapping("/refresh")
    public Result<Boolean> refresh(@RequestParam List<Integer> ceaIds) {
        return ceaService.refresh(ceaIds);
    }

    @GetMapping("/getAllCEA")
    public Result<List<CEAInfoVO>> getAllCEA() {
        return ceaService.getAllCEA();
    }

    @GetMapping("/getOneCEA")
    public Result<CEAInfoVO> getOneCEA(int ceaId) {
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
