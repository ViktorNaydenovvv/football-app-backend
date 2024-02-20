package com.example.diplomaprojectbackend.entity;

import com.example.diplomaprojectbackend.shared.Position;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Footballers")
@Data
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "pace", nullable = false)
    private Integer pace;

    @Column(name = "shooting", nullable = false)
    private Integer shooting;

    @Column(name = "passing", nullable = false)
    private Integer passing;

    @Column(name = "dribbling", nullable = false)
    private Integer dribbling;

    @Column(name = "physique", nullable = false)
    private Integer physique;

    @Column(name = "defending", nullable = false)
    private Integer defending;
}
