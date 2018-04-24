package com.system.po;

import com.alibaba.fastjson.JSONArray;

public class Classes {

    private Integer clsId;
    private String schYear;
    private Integer monitor;
    private JSONArray deMonitor;
    private Integer major;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public String getSchYear() {
        return schYear;
    }

    public void setSchYear(String schYear) {
        this.schYear = schYear;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public JSONArray getDeMonitor() {
        return deMonitor;
    }

    public void setDeMonitor(JSONArray deMonitor) {
        this.deMonitor = deMonitor;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }
}
