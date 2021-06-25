package com.bonc.cron.cronTest.ceainject.entity;

import java.util.Date;

/**
 * CEA 信息
 * @author ZhengHang
 * @create 2021-06-07 15:59
 */
public class CEAInfoVO {
    private int id;
    private String name;
    private String ip;
    private String remark;
    private int status;

    public CEAInfoVO(int id, String name, String ip, String remark , int status) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.remark = remark;
        this.status = status;
    }

    public CEAInfoVO(int id , String name, String ip, String remark) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.remark = remark;
    }


    public CEAInfoVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CEAInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
