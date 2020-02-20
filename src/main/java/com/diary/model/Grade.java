package com.diary.model;

public class Grade {

    public Grade(Integer gradeValue, String subject) {
        this.gradeValue = gradeValue;
        this.subject = subject;
    }

    private Integer gradeValue;

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Integer gradeValue) {
        this.gradeValue = gradeValue;
    }
}
