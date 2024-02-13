package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
