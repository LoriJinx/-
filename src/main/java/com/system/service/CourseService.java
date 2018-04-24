package com.system.service;

import com.system.po.CourseDTO;

import java.util.List;

/**
 * CourseService课程信息.
 */
public interface CourseService {
    //根据id更新课程信息
    void upadteById(Integer id, CourseDTO courseCustom) throws Exception;

    //根据id删除课程信息
    Boolean removeById(Integer id) throws Exception;

    //获取分页查询课程信息
    List<CourseDTO> findCourseById(int uid) throws Exception;

    //插入课程信息
    Boolean save(CourseDTO couseCustom) throws Exception;

    //获取课程总数
    int getCountCouse() throws Exception;

    //根据id查询
    CourseDTO findById(Integer id) throws Exception;

    //根据名字查询
    List<CourseDTO> findByName(String name) throws Exception;

    //根据教师id查找课程
    List<CourseDTO> findByTeacherID(Integer id) throws Exception;
}
