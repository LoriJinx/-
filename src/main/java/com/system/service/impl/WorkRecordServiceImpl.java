package com.system.service.impl;

import com.system.mapper.WorkRecordMapper;
import com.system.po.WorkRecord;
import com.system.service.WorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRecordServiceImpl implements WorkRecordService {

    @Autowired
    private WorkRecordMapper mapper;

    public List<WorkRecord> select7DayByTeaId(int teaId) {
        return mapper.select7Day(teaId);
    }

    @Override
    public List<WorkRecord> selectAllByTeaId(int teaId) {
        return mapper.selectAllByTeaId(teaId);
    }

    @Override
    public Integer delete(int wrId) {
        return mapper.delete(wrId);
    }
}
