package com.bonc.cron.cronTest.ceainject.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bonc.cron.cronTest.ceainject.dao.CEAClusterInfoDao;
import com.bonc.cron.cronTest.ceainject.dao.CEADao;
import com.bonc.cron.cronTest.ceainject.dao.ClusterStatusDao;
import com.bonc.cron.cronTest.ceainject.entity.*;
import com.bonc.cron.cronTest.ceainject.service.CEAService;
import com.bonc.cron.cronTest.result.Result;
import com.bonc.cron.cronTest.utils.JavaBeanUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhengHang
 * @create 2021-06-07 17:30
 */
@Service
public class CEAServiceImpl implements CEAService {

    private static Logger logger = LoggerFactory.getLogger(CEAServiceImpl.class);

    @Autowired
    CEADao ceaDao;

    @Autowired
    CEAClusterInfoDao clusterInfoDao;

    @Autowired
    ClusterStatusDao clusterStatusDao;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Transactional
    @Override
    public Result<Boolean> addCEA(CEAInfoVO info) {
        logger.info("insert ceaInfo info:" + info);
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        String ceaUrl = "http://" + info.getIp() + "/DBService/whitelist/getClusterList";
        String ceaUrl = "http://localhost:8081/ceaInject/test";
        HttpPost post = new HttpPost(ceaUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                CEAInfoPO ceaInfoPO = JavaBeanUtil.copyBean(info, CEAInfoPO.class);
                ceaInfoPO.setStatus(1);
                if (ceaDao.addCEAInfo(ceaInfoPO) == 0) {
                    return new Result<>(400, "fail to add cea info to database", false);
                }
                info.setId(ceaInfoPO.getId());
                String context = EntityUtils.toString(response.getEntity(), "UTF-8");
                threadPoolTaskExecutor.submit(() -> {
                    int ceaId = info.getId();
                    JSONArray jsonArray = JSONArray.parseArray(context);
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        List<CEAClusterInfoPO> clusterInfo = new ArrayList<>(9);
                        String clusterId = jsonObject.getString("clusterId");
                        if (clusterId != null && !clusterId.equals("")) {
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.CLUSTER_NAME.name(), jsonObject.getString("clusterName")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.ZOOKEEPER_ADDRESS.name(), jsonObject.getString("zookeeperAddress")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.XCLOUD_CLUSTER_NAME.name(), jsonObject.getString("xcloudClusterName")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.XCLOUD_ROOT_NAME.name(), jsonObject.getString("xcloudRootName")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.HADOOP_USER.name(), jsonObject.getString("hadoopUser")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.PRINCIPAL.name(), jsonObject.getString("kerbPrincipal")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.KEYTAB.name(), jsonObject.getString("kerbKeytabFile")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.KRB5_CONF.name(), jsonObject.getString("krb5Conf")));
                            clusterInfo.add(new CEAClusterInfoPO(ceaId, clusterId, ClusterKey.CIRRO_VERSION.name(), jsonObject.getString("currentVersion")));
                            int clusterResult = clusterInfoDao.addClusterInfo(clusterInfo);
                            int statusResult = clusterStatusDao.addClusterStatus(new CEAClusterStatusPO(ceaId, clusterId, 0));
                            if (clusterResult == 0 || statusResult != 9) {
                                logger.error("addCEA ERROR : status or clusterInfo can't add to database , clusterResult = " + clusterResult + ", statusResult = " + statusResult);
                            }
                        } else {
                            logger.error("addCEA ERROR : the clusterId is null , ceaId = " + ceaId + " clusterId = " + clusterId);
                        }
                    }
                    if (ceaDao.updateCEAInfo(new CEAInfoPO(ceaId, 0)) > 0) {
                        logger.info("success to add CEA Cluster Info!ceaId = " + ceaId);
                    }
                });
                return new Result<>(200, "success get info", true);
            } else {
                logger.error("addCEA ERROR : can not get info from CEA , exit code =" + response.getStatusLine().getStatusCode());
                return new Result<>(response.getStatusLine().getStatusCode(), "can not get info from CEA", false);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("addCEA ERROR :" + e.getMessage());
            return new Result<>(400, "addCEA ERROR : CEA address is invalid ," + e.getMessage(), false);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional
    @Override
    public Result<Boolean> deleteCEA(int ceaId) {
        logger.info("delete ceaInfo info , ceaId = :" + ceaId);
        if (checkClusterUsed(ceaId)) {
            return new Result<>(500, "The cea cluster has been referenced by plan and cannot be deleted", false);
        } else {
            int flag = ceaDao.deleteCEAInfo(ceaId);
            clusterStatusDao.deleteClusterStatusByCEAId(ceaId);
            if (flag != 0) {
                return new Result<>(200, "success", true);
            }else {
                return new Result<>(400, "fail to delete CEAInfo from database", true);
            }
        }
    }

    @Override
    public Result<CEAInfoVO> getOneCEA(int ceaId) {
        logger.info("get ceaInfo info , ceaId = :" + ceaId);
        CEAInfoPO ceaInfoPO = ceaDao.selectOneCEAInfo(ceaId);
        if (ceaInfoPO != null) {
            return new Result<>(200, "success", JavaBeanUtil.copyBean(ceaInfoPO, CEAInfoVO.class));
        } else {
            return new Result<>(400, "can not find this CEA, ceaId = " + ceaId, null);
        }
    }

    @Transactional
    @Override
    public Result<Boolean> editCEA(CEAInfoVO info) {
        logger.info("update ceaInfo info:" + info);
        CEAInfoPO ceaInfoPO = ceaDao.selectOneCEAInfo(info.getId());
        if (ceaInfoPO == null) {
            return new Result<>(400, "fail to find cea info : " + info, false);
        }
        if (ceaInfoPO.getIp().equalsIgnoreCase(info.getIp())) {
            int result = ceaDao.updateCEAInfo(JavaBeanUtil.copyBean(info, CEAInfoPO.class));
            if (result > 0) {
                return new Result<>(200, "success", true);
            } else {
                return new Result<>(400, "fail to update cea info", false);
            }
        } else {
            Result<Boolean> result = deleteCEA(info.getId());
            if (result.getCode() == 200) {
                return addCEA(info);
            } else {
                return result;
            }
        }
    }

    @Transactional
    @Override
    public Result<Boolean> refresh(List<Integer> ceaIds) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        List<Integer> failCeaIds = new LinkedList<>();
        try {
            for (Integer ceaId : ceaIds) {
                CEAInfoPO info = ceaDao.selectOneCEAInfo(ceaId);
                if (info == null) {
                    failCeaIds.add(ceaId);
                    continue;
                }
                //        String ceaUrl = "http://" + info.getIp() + "/DBService/whitelist/getClusterList";
                String ceaUrl = "http://localhost:8081/ceaInject/test1";
                HttpPost post = new HttpPost(ceaUrl);
                response = httpclient.execute(post);
                ceaDao.updateCEAInfo(new CEAInfoPO(info.getId(), 1));
                if (response.getStatusLine().getStatusCode() == 200) {
                    String context = EntityUtils.toString(response.getEntity(), "UTF-8");
                    threadPoolTaskExecutor.submit(() -> {
                        int ceaId1 = info.getId();
                        if (deleteCEA(ceaId1).getCode() != 200) {
                            logger.error("can not delete ceaInfo ceaId = " + ceaId1);
                        }
                        JSONArray jsonArray = JSONArray.parseArray(context);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            List<CEAClusterInfoPO> clusterInfo = new ArrayList<>(9);
                            String clusterId = jsonObject.getString("clusterId");
                            if (clusterId != null && !clusterId.equals("")) {
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.CLUSTER_NAME.name(), jsonObject.getString("clusterName")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.ZOOKEEPER_ADDRESS.name(), jsonObject.getString("zookeeperAddress")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.XCLOUD_CLUSTER_NAME.name(), jsonObject.getString("xcloudClusterName")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.XCLOUD_ROOT_NAME.name(), jsonObject.getString("xcloudRootName")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.HADOOP_USER.name(), jsonObject.getString("hadoopUser")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.PRINCIPAL.name(), jsonObject.getString("kerbPrincipal")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.KEYTAB.name(), jsonObject.getString("kerbKeytabFile")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.KRB5_CONF.name(), jsonObject.getString("krb5Conf")));
                                clusterInfo.add(new CEAClusterInfoPO(ceaId1, clusterId, ClusterKey.CIRRO_VERSION.name(), jsonObject.getString("currentVersion")));
                                int statusResult = clusterStatusDao.updateClusterStatus(new CEAClusterStatusPO(ceaId1, clusterId, 0));
                                int clusterResult;
                                if (statusResult == 0) {
                                    logger.info("add Cluster Info");
                                    statusResult = clusterStatusDao.addClusterStatus(new CEAClusterStatusPO(ceaId1, clusterId, 0));
                                    clusterResult = clusterInfoDao.addClusterInfo(clusterInfo);
                                } else {
                                    clusterResult = clusterInfoDao.updateClusterInfo(clusterInfo);
                                }
                                if (statusResult == 0 || clusterResult != 9) {
                                    logger.error("addCEA ERROR : status or clusterInfo can't add to database , clusterResult = " + clusterResult + ", statusResult = " + statusResult);
                                }
                            } else {
                                logger.error("addCEA ERROR : the clusterId is null , ceaId = " + ceaId1 + " clusterId = " + clusterId);
                            }
                        }
                        if (ceaDao.updateCEAInfo(new CEAInfoPO(ceaId1, 0)) > 0) {
                            logger.info("success to update CEA Cluster Info!ceaId =  " + ceaId1);
                        }
                    });
                } else {
                    logger.error("addCEA ERROR : can not get info from CEA , exit code =" + response.getStatusLine().getStatusCode());
                    return new Result<>(response.getStatusLine().getStatusCode(), "can not get info from CEA", false);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("addCEA ERROR :" + e.getMessage());
            return new Result<>(400, "refreshCEA ERROR :CEA address is invalid , " + e.getMessage(), false);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (failCeaIds.size() != 0) {
            StringBuilder fails = new StringBuilder();
            fails.append("[");
            for (Integer failCeaId : failCeaIds) {
                fails.append(failCeaId);
                fails.append(",");
            }
            fails.deleteCharAt(fails.length()-1);
            fails.append("]");
            return new Result<>(400, "can't find this CEA" + fails.toString(), false);
        }
        return new Result<>(200, "success", true);
    }

    @Override
    public Result<List<CEAInfoVO>> getAllCEA() {
        List<CEAInfoPO> ceaInfoPOS = ceaDao.selectAllCEAInfo();
        if (ceaInfoPOS != null && ceaInfoPOS.size() > 0) {
            List<CEAInfoVO> results = JavaBeanUtil.copyListBean(ceaInfoPOS, CEAInfoVO.class);
            return new Result<>(200, "success", results);
        } else {
            return new Result<>(400, "can not find cea info", null);
        }
    }

    /**
     * @param ceaId 需要检查占用的cea序号
     * @return 有占用时返回true，否则返回false
     */
    private boolean checkClusterUsed(int ceaId) {
        return false;
    }

}
