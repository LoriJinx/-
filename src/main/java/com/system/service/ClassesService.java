package com.system.service;

import com.system.po.ClassDTO;
import com.system.po.Classes;

import java.util.List;

public interface ClassesService {

    List<ClassDTO> selectByTeacherId(int teacherId);

    List<Classes> selectClsNameByTeaId(int teaId);
}
