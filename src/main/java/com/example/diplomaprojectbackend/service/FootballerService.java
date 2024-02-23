package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FootballerService {
    void save(CreateFootballerReq createFootballerReq);
    Page<Footballer> fetch(FetchFootballersFilters filters, Pageable pageable);
    Footballer getFootballer(Long id);
    Footballer updateFootballer(Long id, UpdateFootballerReq footballerData);
    void deleteFootballer(Long id);
}
