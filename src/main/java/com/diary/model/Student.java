package com.diary.model;

import java.util.List;

public class Student {

    public Student(String studentFirstName, String studentLastName, List<Grade> gradeList) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.gradeList = gradeList;
    }

    private String studentFirstName;

    private String studentLastName;

    private List<Grade> gradeList;

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
