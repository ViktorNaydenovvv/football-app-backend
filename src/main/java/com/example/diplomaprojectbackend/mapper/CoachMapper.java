package com.example.diplomaprojectbackend.mapper;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.entity.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoachMapper {
    CoachMapper COACH_MAPPER = Mappers.getMapper(CoachMapper.class);

    @Mapping(source = "profileData", target = "user")
    Coach fromCreateCoachReq(CreateCoachReq createCoachReq);
}
