package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.Position;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFootballerReq {
    @NotNull
    private CreateUserDto profileData;

    @NotNull
    private String teamName;

    @NotNull
    private Position position;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer pace;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer shooting;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer passing;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer dribbling;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer physique;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer defending;
}
