package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.CourseMapper;
import com.system.mapper.SelectedcourseMapper;
import com.system.po.*;
import com.system.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseMapper courseMapperCustom;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private SelectedcourseMapper selectedcourseMapper;

    public void upadteById(Integer id, CourseDTO courseCustom) throws Exception {
    }

    public Boolean removeById(Integer id) throws Exception {
        //自定义查询条件
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);
        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);

        if (list.size() == 0) {
            return true;
        }

        return false;
    }

    public List<CourseDTO> findCourseById(int uid) throws Exception {

        List<CourseDTO> list = courseMapperCustom.find(uid);
        return list;
    }

    public Boolean save(CourseDTO couseCustom) throws Exception {
        return true;
    }

    public int getCountCouse() throws Exception {
        //自定义查询对象
        CourseExample courseExample = new CourseExample();
        //通过criteria构造查询条件
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursenameIsNotNull();

        return 2;
    }

    public CourseDTO findById(Integer id) throws Exception {
        CourseDTO courseCustom = null;
        return courseCustom;
    }

    public List<CourseDTO> findByName(String name) throws Exception {
        CourseExample courseExample = new CourseExample();
        //自定义查询条件
        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andCoursenameLike("%" + name + "%");


        List<CourseDTO> courseCustomList = null;

        courseCustomList = new ArrayList<CourseDTO>();
        return courseCustomList;
    }

    public List<CourseDTO> findByTeacherID(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();
        //自定义查询条件
        CourseExample.Criteria criteria = courseExample.createCriteria();
        //根据教师id查课程
        criteria.andTeacheridEqualTo(id);
        List<CourseDTO> courseCustomList = null;
        courseCustomList = new ArrayList<CourseDTO>();
        return courseCustomList;
    }
}
