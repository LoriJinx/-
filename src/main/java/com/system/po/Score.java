package com.system.po;

public class Score {

    private Integer teacher;
    private Integer student;
    private Double score;
    private String semester;

    public Score() {
    }

    public Score(int teacher, int student, double score, String semester){
        this.teacher = teacher;
        this.student = student;
        this.score = score;
        this.semester = semester;
    }
    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
