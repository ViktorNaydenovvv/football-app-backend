package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.controller.resource.UpdateFootballerReq;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.service.FootballerService;
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
@RequestMapping("/api/v1/footballers")
@RequiredArgsConstructor
public class FootballerController {
    private final FootballerService footballerService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public void create(@Valid @RequestBody CreateFootballerReq createFootballerReq) {
        footballerService.save(createFootballerReq);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Footballer>> fetch(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @Valid @RequestBody FetchFootballersFilters filters
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Footballer> footballers = footballerService.fetch(filters, pageable);
        return ResponseEntity.ok(footballers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Footballer> getFootballer(@PathVariable Long id) {
        return ResponseEntity.ok(footballerService.getFootballer(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Footballer>> searchByUsername(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String username
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Footballer> footballers = footballerService.findByUsername(username, pageable);
        return ResponseEntity.ok(footballers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Footballer> updateFootballer(@NotNull HttpServletRequest request, @PathVariable Long id, @Valid @RequestBody UpdateFootballerReq footballerData) {
        String jwt = jwtService.extractJwtFromRequest(request);
        String email = jwtService.extractEmail(jwt);

        return ResponseEntity.ok(footballerService.updateFootballer(id, footballerData, email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballer(@NotNull HttpServletRequest request, @PathVariable Long id) {
        String jwt = jwtService.extractJwtFromRequest(request);
        String email = jwtService.extractEmail(jwt);

        footballerService.deleteFootballer(id, email);

        return ResponseEntity.noContent().build();
    }
}