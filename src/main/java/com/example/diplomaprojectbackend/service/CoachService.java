package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.entity.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoachService {
    void save(CreateCoachReq createCoachReq);
    Page<Coach> fetch(FetchCoachesFilters filters, Pageable pageable);
}
