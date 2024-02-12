package com.example.diplomaprojectbackend.entity;

public enum UserType {
    COACH("Coach"),
    FOOTBALLER("Footballer"),
    GOALKEEPER("Goalkeeper");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }
}
