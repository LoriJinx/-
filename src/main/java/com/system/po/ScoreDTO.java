package com.system.po;

public class ScoreDTO extends Score {

    private String teacherName;
    private Boolean hasScore;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Boolean getHasScore() {
        return hasScore;
    }

    public void setHasScore(Boolean hasScore) {
        this.hasScore = hasScore;
    }
}
