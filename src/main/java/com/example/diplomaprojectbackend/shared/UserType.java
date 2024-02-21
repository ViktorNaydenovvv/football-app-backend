package com.example.diplomaprojectbackend.shared;

public enum UserType {
    COACH("Coach"),
    FOOTBALLER("Footballer");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }
}
