package com.diary.model;

import com.diary.model.admin.Teacher;

import java.util.Objects;

public class Class {

    public Class(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    private Teacher classTeacher;

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(classTeacher, aClass.classTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classTeacher);
    }

    @Override
    public String toString() {
        return "Class{" +
                "classTeacher=" + classTeacher +
                '}';
    }
}
