package com.example.diplomaprojectbackend.service;

import com.example.diplomaprojectbackend.entity.User;

import java.util.List;

public interface FavoriteService {
    void addFavorite(Long userId, Long favoriteUserId);
    List<User> getFavorites(Long userId);
}
