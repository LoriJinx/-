package com.system.mapper;

import com.system.po.WorkRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorkRecordMapper {


    @Select("select wr_id, create_time, description from work_record where tea_id=#{teaId} and DATE_FORMAT(create_time, '%Y-%m-%d') > ADDDATE(DATE_FORMAT(now(), '%Y-%m-%d'), INTERVAL -7 DAY) order by create_time desc")
    List<WorkRecord> select7Day(@Param("teaId")int teaId);

    @Select("select wr_id, create_time, description from work_record where tea_id=#{teaId} order by create_time")
    List<WorkRecord> selectAllByTeaId(@Param("teaId")int teaId);

    @Update("update work_record set description=#{workRecord.description} where wr_id=#{workRecord.wrId}}")
    Integer update(@Param("workRecord")WorkRecord workRecord);

    @Insert("insert into work_record(tea_id, description) values(#{workRecord.teaId}, #{workRecord.description})")
    Integer insert(@Param("workRecord")WorkRecord workRecord);

    @Delete("delete from work_record where wr_id=#{wrId}")
    Integer delete(@Param("wrId") int wrId);
}
