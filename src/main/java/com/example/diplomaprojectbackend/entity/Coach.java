package com.example.diplomaprojectbackend.entity;

import com.example.diplomaprojectbackend.shared.UserType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Coaches")
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false, referencedColumnName = "id")
    private Team team;

    @Column(name = "type", nullable = false, columnDefinition = "ENUM('Head coach', 'Assistant coach', 'Goalkeeper coach', 'Fitness coach', 'Conditioning coach')")
    private UserType coachType;

    @Column(name = "experience", nullable = false, columnDefinition = "INT")
    private Integer experience;
}
