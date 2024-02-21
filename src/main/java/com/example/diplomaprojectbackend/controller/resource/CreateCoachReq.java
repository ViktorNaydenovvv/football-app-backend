package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.CoachType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCoachReq {
    @NotNull
    private CreateUserDto profileData;

    @NotNull
    private String teamName;

    @NotNull
    private CoachType coachType;

    @NotNull
    @Min(1)
    private Integer experience;
}
