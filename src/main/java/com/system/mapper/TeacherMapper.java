package com.system.mapper;

import com.system.po.Teacher;
import com.system.po.TeacherExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer userid);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    @Select("select uid,name,sex,title,phone,area,birthday from users where uid = " +
            "(select teacher from classes where cls_id = (select class_id " +
            "from users where uid = #{studentId}) )")
    Teacher selectByStuId(@Param("studentId") int studentId);

    //默认密码12345678
    @Insert("insert into users(account,name,sex,title,phone,area,birthday,role) values(#{t.account},#{t.name},#{t.sex},#{t.title},#{t.phone},#{t.area},#{t.role})")
    Integer insert(@Param("t") Teacher teacher);

    Integer update(Teacher teacher);

    @Delete("delete from users where uid = #{uid} and role = 1")
    Integer delete(@Param("uid") int uid);

    @Select("select uid,account,name,sex,title,phone,area,birthday from users where role=1")
    List<Teacher> selectAll();

}