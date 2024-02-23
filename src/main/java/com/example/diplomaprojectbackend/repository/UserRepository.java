package com.example.diplomaprojectbackend.repository;

import com.example.diplomaprojectbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByUsername(String username);
}
