package com.example.diplomaprojectbackend.entity;

public enum CoachType {
    HEAD_COACH("Head coach"),
    ASSISTANT_COACH("Assistant coach"),
    GOALKEEPER_COACH("Goalkeeper coach"),
    FITNESS_COACH("Fitness coach"),
    CONDITIONING_COACH("Conditioning coach");

    private final String displayName;

    CoachType(String displayName) {
        this.displayName = displayName;
    }
}
