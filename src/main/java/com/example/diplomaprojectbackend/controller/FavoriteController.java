package com.example.diplomaprojectbackend.controller;

import com.example.diplomaprojectbackend.entity.User;
import com.example.diplomaprojectbackend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping
    public void addFavorite(@RequestParam Long userId, @RequestParam Long favoriteUserId) {
        favoriteService.addFavorite(userId, favoriteUserId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<User>> getFavorites(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteService.getFavorites(userId));
    }
}
