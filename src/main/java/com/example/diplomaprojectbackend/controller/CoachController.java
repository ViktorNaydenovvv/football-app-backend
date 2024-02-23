package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.service.CoachService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    //private final JwtService jwtService;

    @PostMapping("/register")
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

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoach(@PathVariable Long id) {
        return ResponseEntity.ok(coachService.getCoach(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @Valid @RequestBody UpdateCoachReq coachData) {
        return ResponseEntity.ok(coachService.updateCoach(id, coachData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        //(@NotNull HttpServletRequest request)
        //String jwt = jwtService.extractJwtFromRequest(request);
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}
