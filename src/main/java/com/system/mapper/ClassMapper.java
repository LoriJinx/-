package com.system.mapper;

import com.system.po.ClassDTO;
import com.system.po.Classes;
import com.system.utils.JsonTypeHandler;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {

    @Results({
            @Result(column = "de_monitor_name", property = "deMonitorName", typeHandler = JsonTypeHandler.class)
    })
    @Select("SELECT c.cls_id,u.name as monitor_name,JSON_ARRAY(d1.name, d2.name) as de_monitor_name,m.name as majorName from classes c, users u, users d1, users d2, major m where c.teacher=#{teacherId} and u.uid=c.monitor and d1.uid=c.de_monitor -> '$[0]' and d2.uid=c.de_monitor -> '$[1]' and c.major=m.major_id")
    List<ClassDTO> selectByTeacher(@Param("teacherId") int teacherId);

    @Select("select cls_id,name from classes where teacher=#{teaId} order by cls_id")
    List<Classes> selectClsNameByTeaId(@Param("teaId") int teaId);
}
