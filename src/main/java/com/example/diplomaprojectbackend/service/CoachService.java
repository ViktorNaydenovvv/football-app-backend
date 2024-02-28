package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoachService {
    void save(CreateCoachReq createCoachReq);
    Page<Coach> fetch(FetchCoachesFilters filters, Pageable pageable);
    Coach getCoach(Long id);
    Page<Coach> findByUsername(String username, Pageable pageable);
    Coach updateCoach(Long id, UpdateCoachReq coachData, String email);
    void deleteCoach(Long id, String email);
}
