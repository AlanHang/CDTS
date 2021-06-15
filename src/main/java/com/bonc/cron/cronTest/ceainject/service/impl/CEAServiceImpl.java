package com.bonc.cron.cronTest.ceainject.service.impl;

import com.bonc.cron.cronTest.ceainject.dao.CEAClusterInfoDao;
import com.bonc.cron.cronTest.ceainject.dao.CEADao;
import com.bonc.cron.cronTest.ceainject.dao.ClusterStatusDao;
import com.bonc.cron.cronTest.ceainject.entity.CEAClusterInfoPO;
import com.bonc.cron.cronTest.ceainject.entity.CEAInfoVO;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-07 17:30
 */
public class CEAServiceImpl implements CEAService {

    private static Logger logger = LoggerFactory.getLogger(CEAServiceImpl.class);

    @Autowired
    CEADao ceaDao;

    @Autowired
    CEAClusterInfoDao clusterInfoDao;

    @Autowired
    ClusterStatusDao clusterStatusDao;

    @Override
    public boolean addCEA(CEAInfoVO info) {
        return false;
    }

    @Override
    public boolean deleteCEA(int ceaId) {
        return false;
    }

    @Override
    public boolean editCEA(CEAInfoVO info) {
        return false;
    }

    @Override
    public boolean refresh(CEAInfoVO info) {
        return false;
    }

    @Override
    public List<CEAInfoVO> getAllCEA() {
        return null;
    }

    private boolean checkClusterUsed(int ceaId) {
        return false;
    }
}
