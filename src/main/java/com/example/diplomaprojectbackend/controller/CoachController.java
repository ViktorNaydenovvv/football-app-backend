package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.CreateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.FetchCoachesFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateCoachReq;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.service.CoachService;
import com.example.diplomaprojectbackend.service.JwtService;
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
    private final JwtService jwtService;

    @PostMapping("/register")
    public void create(@Valid @RequestBody CreateCoachReq createCoachReq) {
        coachService.save(createCoachReq);
    }

    @GetMapping
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

    @GetMapping("/search")
    public ResponseEntity<Page<Coach>> searchByUsername(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String username
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Coach> coaches = coachService.findByUsername(username, pageable);
        return ResponseEntity.ok(coaches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@NotNull HttpServletRequest request, @PathVariable Long id, @Valid @RequestBody UpdateCoachReq coachData) {
        String jwt = jwtService.extractJwtFromRequest(request);
        String email = jwtService.extractEmail(jwt);

        return ResponseEntity.ok(coachService.updateCoach(id, coachData, email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@NotNull HttpServletRequest request, @PathVariable Long id) {
        String jwt = jwtService.extractJwtFromRequest(request);
        String email = jwtService.extractEmail(jwt);

        coachService.deleteCoach(id, email);

        return ResponseEntity.noContent().build();
    }
}
