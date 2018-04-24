package com.system.controller;

import com.system.po.*;
import com.system.service.*;
import com.system.utils.SemesterUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "classesServiceImpl")
    private ClassesService classesService;

    @Resource(name = "workRecordServiceImpl")
    private WorkRecordService workRecordService;

    @Resource(name = "scoreServiceImpl")
    private ScoreService scoreService;

    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model) throws Exception {

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Session session = SecurityUtils.getSubject().getSession();
        List<CourseDTO> courses = null;
        courses = courseService.findCourseById(user.getUid());

        model.addAttribute("courseList", courses);

        return "student/showCourse";
    }


    // 我的导师
    @RequestMapping(value = "/myTeacher")
    public String selectedCourse(Model model) throws Exception {
        //获取当前用户名
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");

        Teacher teacher = teacherService.findByStudentId(user.getUid());
        List<ClassDTO> classes = classesService.selectByTeacherId(teacher.getUid());
        List<WorkRecord> workRecords = workRecordService.select7DayByTeaId(teacher.getUid());
        model.addAttribute("teacher", teacher);
        model.addAttribute("classes", classes);
        model.addAttribute("workRecords", workRecords);
        model.addAttribute("age", Period.between(
                teacher.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                LocalDate.now()).getYears());

        return "student/myTeacher";
    }

    // 导师评分
    @RequestMapping(value = "/scoring")
    public String scoring(Model model) throws Exception {

        //获取当前用户名
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String currentSemester = SemesterUtils.currentSemester();
        Teacher teacher = teacherService.findByStudentId(user.getUid());
        ScoreDTO scoreDTO = scoreService.selectByTeacher(teacher.getUid(), user.getUid(), currentSemester);
        if (scoreDTO == null) {
            scoreDTO = new ScoreDTO();
            scoreDTO.setTeacherName(teacher.getName());
            scoreDTO.setSemester(currentSemester);
        }
        model.addAttribute("score", scoreDTO);
        return "student/score";
    }

    @RequestMapping(value = "/addScore", method = {RequestMethod.POST})
    public String addScore(double score) throws Exception {

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String currentSemester = SemesterUtils.currentSemester();
        Teacher teacher = teacherService.findByStudentId(user.getUid());
        Score sc = new Score(teacher.getUid(), user.getUid(), score, currentSemester);
        scoreService.addScore(sc);
        return "redirect:/student/scoring";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "student/passwordRest";
    }


}
