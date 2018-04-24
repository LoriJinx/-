package com.system.service.impl;

import com.system.mapper.ClassMapper;
import com.system.po.ClassDTO;
import com.system.po.Classes;
import com.system.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassMapper classMapper;

    public List<ClassDTO> selectByTeacherId(int teacherId) {
        return classMapper.selectByTeacher(teacherId);
    }

    public List<Classes> selectClsNameByTeaId(int teaId) {
        return classMapper.selectClsNameByTeaId(teaId);
    }
}
