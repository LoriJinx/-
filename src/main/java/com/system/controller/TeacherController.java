package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.*;
import com.system.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Resource(name = "classesServiceImpl")
    private ClassesService classesService;

    @Resource(name = "activityInfoServiceImpl")
    private ActivityInfoService activityInfoService;

    @Resource(name = "workRecordServiceImpl")
    private WorkRecordService workRecordService;

    // 显示我管理的班级
    @RequestMapping(value = "/showClasses")
    public String classesShow(Model model) throws Exception {

        User teacher = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<ClassDTO> classes = classesService.selectByTeacherId(teacher.getUid());
        model.addAttribute("classes", classes);

        return "teacher/showClasses";
    }

    // 显示综合信息
    @RequestMapping(value = "/showActivityInfo/{clsId}")
    public String showActivityInfo(@PathVariable(value = "clsId") int clsId, Model model) throws Exception {
        User teacher = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<Classes> classes = classesService.selectClsNameByTeaId(teacher.getUid());
        if (clsId != 0) {
            final int a = clsId;
            if (classes.stream().filter(cls -> cls.getClsId() == a).collect(Collectors.toList()).size() < 1) {
                throw new CustomException("请检查班级ID！");
            }
        } else {
            clsId = classes.get(0).getClsId();
        }
        List<ActivityInfoDTO> activityInfos = activityInfoService.selectByClsId(clsId);
        model.addAttribute("activityInfos", activityInfos)
                .addAttribute("classes", classes)
                .addAttribute("selected", clsId);
        return "teacher/activityInfo";
    }

    //删除综合信息
    @RequestMapping(value = "/activityInfo", method = {RequestMethod.DELETE})
    @ResponseBody
    public String deleteActivityInfo(Integer aiId) {
        if (aiId == null) {
            return "fail";
        }
        Integer delete = activityInfoService.delete(aiId);
        if (delete == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    // 工作记录
    @RequestMapping(value = "/showWorkRecord")
    public String showWorkRecord(Model model) {
        User teacher = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<WorkRecord> workRecords = workRecordService.selectAllByTeaId(teacher.getUid());
        model.addAttribute("workRecords", workRecords);
        return "teacher/workRecord";
    }

    //删除工作记录
    @RequestMapping(value = "/workRecord", method = {RequestMethod.DELETE})
    @ResponseBody
    public String deleteWorkRecord(Integer wrId) {
        if (Objects.isNull(wrId)) {
            return "fail";
        }
        Integer delete = workRecordService.delete(wrId);
        if (delete == 1) {
            return "success";
        }
        return "fail";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "teacher/passwordRest";
    }

}
