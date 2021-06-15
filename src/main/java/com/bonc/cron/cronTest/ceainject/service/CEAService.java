package com.bonc.cron.cronTest.ceainject.service;

import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;

import java.util.List;

/**
 * cea服务类
 * @author ZhengHang
 * @create 2021-06-07 17:25
 */
public interface CEAService {
    boolean addCEA(CEAInfoVO info);
    boolean deleteCEA(int ceaId);
    boolean editCEA(CEAInfoVO info);
    boolean refresh(CEAInfoVO info);
    List<CEAInfoVO> getAllCEA();
}
