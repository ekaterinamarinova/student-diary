package com.diary.model;

import java.util.List;

public class Teacher {

    public Teacher(String teacherName, List<Student> studentList) {
        this.teacherName = teacherName;
        this.studentList = studentList;
    }

    private String teacherName;
    private List<Student> studentList;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
