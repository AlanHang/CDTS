package com.bonc.cron.cronTest.ceainject.service;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.result.Result;

import java.util.List;

/**
 * cea服务类
 * @author ZhengHang
 * @create 2021-06-07 17:25
 */
public interface CEAService {

    Result<Boolean>  addCEA(CEAInfoVO info);

    Result<Boolean> deleteCEA(int ceaId);

    Result<Boolean> editCEA(CEAInfoVO info);

    Result<Boolean> refresh(List<Integer> ceaIds);

    Result<List<CEAInfoVO>> getAllCEA();

    Result<CEAInfoVO> getOneCEA(int ceaId);
}
