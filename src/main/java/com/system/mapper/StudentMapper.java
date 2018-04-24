package com.system.mapper;

import com.system.po.Student;
import com.system.po.StudentDTO;
import com.system.po.StudentExample;
import com.system.po.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer userid);


    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //默认密码12345678
    @Insert("insert into users(account,name,sex,title,phone,area,birthday,role) values(#{s.account},#{s.name},#{s.sex},#{s.title},#{s.phone},#{s.area},#{s.role})")
    Integer insert(@Param("s") Student student);

    Integer update(Student student);

    @Delete("delete from users where uid = #{uid} and role = 2")
    Integer delete(@Param("uid") int uid);

    @Select("select u.uid,u.account,u.name,u.sex,c.name as cls_name,u.phone,u.area,u.birthday from users u, classes c where role=2 and u.class_id = c.cls_id")
    List<StudentDTO> selectAll();
}