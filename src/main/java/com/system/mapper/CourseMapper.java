package com.system.mapper;

import com.system.po.Course;
import com.system.po.CourseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {

    //查询学生课程
    List<CourseDTO> find(@Param("uid")int uid) throws Exception;

    @Select("select course_id from course where teacher_id=#{teaId}")
    List<Course> selectByTeaId(@Param("teaId")int teaId);

}
