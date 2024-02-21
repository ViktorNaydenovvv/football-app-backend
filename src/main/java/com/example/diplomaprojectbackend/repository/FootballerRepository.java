package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
    Page<Footballer> findAll(Specification<Footballer> spec, Pageable pageable);
    Footballer findByUserId(Long userId);
}
