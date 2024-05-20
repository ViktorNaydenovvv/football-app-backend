package com.example.diplomaprojectbackend.entity;

import com.example.diplomaprojectbackend.shared.CoachType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Coaches")
@Data
public class Coach implements AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    @Column(name = "experience", nullable = false)
    private Integer experience;
}
