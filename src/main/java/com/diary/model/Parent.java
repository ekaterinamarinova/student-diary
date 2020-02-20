package com.diary.model;

import java.util.List;

public class Parent {
    public Parent(List<Student> studentList) {
        this.studentList = studentList;
    }

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
