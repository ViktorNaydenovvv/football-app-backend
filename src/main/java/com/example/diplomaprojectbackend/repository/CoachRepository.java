package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Coach;
import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Page<Coach> findAll(Specification<Coach> spec, Pageable pageable);
    Coach findByUserId(Long userId);
    Page<Coach> findByUserUsernameContaining(String username, Pageable pageable);
}
