package com.bonc.cron.cronTest.ceainject.controller;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import com.bonc.cron.cronTest.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-08 15:31
 */
@Controller
@RequestMapping("/ceaInject")
public class CEAController {

    @Autowired
    CEAService ceaService;

    @PostMapping("/add")
    public Result<Boolean> addCEA(CEAInfoVO info) {
        return null;
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteCEA(int ceaId) {
        return null;
    }

    @GetMapping("/edit")
    public Result<Boolean> editCEA(CEAInfoVO info) {
        return null;
    }

    @PostMapping("/refresh")
    public Result<Boolean> refresh(CEAInfoVO info) {
        return null;
}

    @GetMapping("/getAllCEA")
    public Result<List<CEAInfoVO>> getAllCEA() {
        return null;
    }

}
