package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.controller.resource.FootballerResource;
import com.example.diplomaprojectbackend.service.FootballerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/footballers")
@RequiredArgsConstructor
public class FootballerController {
    private final FootballerService footballerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(footballerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(footballerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FootballerResource footballerResource) {
        FootballerResource saved = footballerService.save(footballerResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/footballers/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FootballerResource footballerResource) {
        return ResponseEntity.ok(footballerService.update(id, footballerResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        footballerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
