package com.example.diplomaprojectbackend.mapper;

import com.example.diplomaprojectbackend.controller.resource.FootballerResource;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface FootballerMapper {
    FootballerMapper FOOTBALLER_MAPPER = Mappers.getMapper(FootballerMapper.class);
    Footballer fromFootballerResource(FootballerResource footballerResource);
    FootballerResource toFootballerResource(Footballer footballer);
    List<FootballerResource> toFootballerResources(List<Footballer> footballers);
}
