package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.CreateFootballerReq;
import com.example.diplomaprojectbackend.controller.resource.FetchFootballersFilters;
import com.example.diplomaprojectbackend.entity.Footballer;
import com.example.diplomaprojectbackend.service.FootballerService;
import jakarta.validation.Valid;
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

    @PostMapping("/")
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
}