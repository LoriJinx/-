package com.system.po;

import com.alibaba.fastjson.JSONArray;

public class ClassDTO extends Classes{

    private String monitorName;
    private JSONArray deMonitorName;
    private String majorName;

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public JSONArray getDeMonitorName() {
        return deMonitorName;
    }

    public void setDeMonitorName(JSONArray deMonitorName) {
        this.deMonitorName = deMonitorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
