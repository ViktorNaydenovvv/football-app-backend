package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
