package com.example.diplomaprojectbackend.controller.resource;

import com.example.diplomaprojectbackend.shared.Position;
import lombok.Data;

@Data
public class FetchFootballersFilters {
    private Position position;
    private String teamName;
}
