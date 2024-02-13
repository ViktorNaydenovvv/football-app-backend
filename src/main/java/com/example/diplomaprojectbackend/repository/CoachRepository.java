package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
