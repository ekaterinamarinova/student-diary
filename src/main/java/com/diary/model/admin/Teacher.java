package com.diary.model.admin;

import com.diary.model.Student;
import com.diary.model.Subject;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Teacher {

    public Teacher(String teacherName, List<Map<Student, List<Grade>>> studentGrades) {
        this.teacherName = teacherName;
        this.studentGrades = studentGrades;
    }

    private String teacherName;
    private List<Map<Student, List<Grade>>> studentGrades;

    public static Grade getGrade(Integer value, Subject subject) {
        return new Grade(value, subject);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Map<Student, List<Grade>>> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<Map<Student, List<Grade>>> studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherName, teacher.teacherName) &&
                Objects.equals(studentGrades, teacher.studentGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherName, studentGrades);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", studentGrades=" + studentGrades +
                '}';
    }
}
