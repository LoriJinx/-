package com.system.service;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.system.po.WorkRecord;

import java.util.List;

public interface WorkRecordService {

    List<WorkRecord> select7DayByTeaId(int teaId);

    List<WorkRecord> selectAllByTeaId(int teaId);

    Integer delete(int wrId);
}
