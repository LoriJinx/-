package com.system.po;

/**
 * Course扩展类    课程
 */
public class CourseDTO extends Course {

    private String major;
    private String teacherName;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
