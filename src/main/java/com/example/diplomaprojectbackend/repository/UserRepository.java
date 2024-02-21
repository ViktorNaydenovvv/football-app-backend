package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
