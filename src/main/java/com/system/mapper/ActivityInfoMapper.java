package com.system.mapper;

import com.system.po.ActivityInfo;
import com.system.po.ActivityInfoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityInfoMapper {

    @Insert("insert into activity_info(uid, description) values(#{activifyInfo.uid},#{activityInfo.description})")
    void insert(@Param("activityInfo") ActivityInfo activityInfo);

    @Update("update activity_info set description=#{activityInfo.description},update_time=#{activityInfo.updateTime} where ai_id=#{activityInfo.aiId}")
    Integer update(@Param("activityInfo") ActivityInfo activityInfo);

    @Select("select ai.ai_id,u.name as u_name,ai.create_time,ai.description from activity_info ai, users u where ai.uid in (select uid from users where class_id = #{clsId}) and ai.uid=u.uid")
    List<ActivityInfoDTO> select(@Param("clsId") int clsId);

    @Delete("delete from activity_info where ai_id=#{aiId}")
    Integer delete(@Param("aiId") int aiId);
}
