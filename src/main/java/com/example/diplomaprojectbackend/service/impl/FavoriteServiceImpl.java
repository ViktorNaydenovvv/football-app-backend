package com.example.diplomaprojectbackend.service.impl;

import com.example.diplomaprojectbackend.entity.Favorite;
import com.example.diplomaprojectbackend.entity.User;
import com.example.diplomaprojectbackend.repository.FavoriteRepository;
import com.example.diplomaprojectbackend.repository.UserRepository;
import com.example.diplomaprojectbackend.service.FavoriteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;

    @Override
    public void addFavorite(Long userId, Long favoriteUserId) {
        if (userId.equals(favoriteUserId)) {
            throw new IllegalArgumentException("User cannot add himself to favorites");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User favoriteUser = userRepository.findById(favoriteUserId).orElseThrow(() -> new EntityNotFoundException("Favorite user not found"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setFavoriteUser(favoriteUser);

        favoriteRepository.save(favorite);
    }

    @Override
    public List<User> getFavorites(Long userId) {
        return favoriteRepository.findByUserId(userId)
                .stream()
                .map(Favorite::getFavoriteUser)
                .collect(Collectors.toList());
    }
}
