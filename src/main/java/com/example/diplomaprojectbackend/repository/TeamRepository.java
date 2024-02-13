package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
