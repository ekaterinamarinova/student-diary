package com.diary.model.enums;

public enum SubjectName {
    ARTS("Arts"),
    CALCULUS("Calculus"),
    SPORTS("Sports");

    private String name;

    SubjectName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
