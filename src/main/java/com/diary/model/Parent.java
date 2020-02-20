package com.diary.model;

import com.diary.model.admin.Grade;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Parent {
    public Parent(Map<Student, List<Grade>> studentNames) {
        this.studentNames = studentNames;
    }

    private Map<Student, List<Grade>> studentNames;

    public Map<Student, List<Grade>> getStudentList() {
        return studentNames;
    }

    public void setStudentList(Map<Student, List<Grade>> studentList) {
        this.studentNames = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(studentNames, parent.studentNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNames);
    }

    @Override
    public String toString() {
        return "Parent{" +
                "studentNames=" + studentNames +
                '}';
    }
}
