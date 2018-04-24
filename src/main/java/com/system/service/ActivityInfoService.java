package com.system.service;

import com.system.po.ActivityInfo;
import com.system.po.ActivityInfoDTO;

import java.util.List;

public interface ActivityInfoService {

    List<ActivityInfoDTO> selectByClsId(int clsId);

    Integer update(ActivityInfo activityInfo);

    Integer select(ActivityInfo activityInfo);

    Integer delete(int aiId);
}
