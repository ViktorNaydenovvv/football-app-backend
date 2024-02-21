package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.service.CoachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coaches")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;

    @PostMapping("/")
    public void create(@Valid @RequestBody CreateCoachReq createCoachReq) {
        coachService.save(createCoachReq);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Coach>> fetch(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @Valid @RequestBody FetchCoachesFilters filters
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Coach> coaches = coachService.fetch(filters, pageable);
        return ResponseEntity.ok(coaches);
    }
}
