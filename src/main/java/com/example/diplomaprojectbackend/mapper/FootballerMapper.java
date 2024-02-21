package com.example.diplomaprojectbackend.mapper;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FootballerMapper {
    FootballerMapper FOOTBALLER_MAPPER = Mappers.getMapper(FootballerMapper.class);

    @Mapping(source = "profileData", target = "user")
    Footballer fromCreateFootballerReq(CreateFootballerReq createFootballerReq);
}
