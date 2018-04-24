package com.system.service.impl;

import com.system.mapper.ActivityInfoMapper;
import com.system.po.ActivityInfo;
import com.system.po.ActivityInfoDTO;
import com.system.service.ActivityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityInfoServiceImpl implements ActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    @Override
    public List<ActivityInfoDTO> selectByClsId(int clsId) {
        return activityInfoMapper.select(clsId);
    }

    @Override
    public Integer update(ActivityInfo activityInfo) {
        return activityInfoMapper.update(activityInfo);
    }

    @Override
    public Integer select(ActivityInfo activityInfo) {
        return null;
    }

    @Override
    public Integer delete(int aiId) {
        return activityInfoMapper.delete(aiId);
    }
}
