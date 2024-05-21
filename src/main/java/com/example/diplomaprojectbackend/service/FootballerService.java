package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FootballerService {
    void save(CreateFootballerReq createFootballerReq) throws IOException;
    Page<Footballer> fetch(FetchFootballersFilters filters, Pageable pageable);
    Footballer getFootballer(Long id);
    Page<Footballer> findByUsername(String username, Pageable pageable);
    Footballer updateFootballer(Long id, UpdateFootballerReq footballerData, String email);
    void deleteFootballer(Long id, String email);
}
