package com.example.diplomaprojectbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(32)")
    private String email;

    @Column(name = "firstName", nullable = false, columnDefinition = "VARCHAR(32)")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "VARCHAR(32)")
    private String lastName;

    @Column(name = "age", nullable = false, columnDefinition = "INT")
    private Integer age;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(256)")
    private String password;

    @Column(name = "type", nullable = false, columnDefinition = "ENUM('Coach', 'Footballer', 'Goalkeeper')")
    private UserType userType;
}
