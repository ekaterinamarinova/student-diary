package com.diary.model.admin;

import com.diary.model.Subject;

import java.util.Objects;

public class Grade {

    Grade(Integer gradeValue, Subject subject) {
        this.gradeValue = gradeValue;
        this.subject = subject;
    }

    private Integer gradeValue;

    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getGradeValue() {
        return gradeValue;
    }

    void setGradeValue(Integer gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(gradeValue, grade.gradeValue) &&
                Objects.equals(subject, grade.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeValue, subject);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeValue=" + gradeValue +
                ", subject=" + subject +
                '}';
    }
}
