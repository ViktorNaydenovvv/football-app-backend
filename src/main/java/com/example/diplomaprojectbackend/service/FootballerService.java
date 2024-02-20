package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.FootballerResource;

import java.util.List;

public interface FootballerService {
    List<FootballerResource> findAll();
    FootballerResource getById(Long id);
    FootballerResource save(FootballerResource footballerResource);
    FootballerResource update(Long id, FootballerResource footballerResource);
    void delete(Long id);
}
