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

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false, referencedColumnName = "id")
    private Team team;

    @Column(name = "position", nullable = false, columnDefinition = "ENUM('CB', 'RB', 'LB', 'RWB', 'LWB', 'CDM', 'CM', 'CAM', 'RW', 'LW', 'ST')")
    private Position position;

    @Column(name = "pace", nullable = false, columnDefinition = "INT")
    private Integer pace;

    @Column(name = "shooting", nullable = false, columnDefinition = "INT")
    private Integer shooting;

    @Column(name = "passing", nullable = false, columnDefinition = "INT")
    private Integer passing;

    @Column(name = "dribbling", nullable = false, columnDefinition = "INT")
    private Integer dribbling;

    @Column(name = "physique", nullable = false, columnDefinition = "INT")
    private Integer physique;

    @Column(name = "defending", nullable = false, columnDefinition = "INT")
    private Integer defending;

    @Column(name = "weak_foot", nullable = false, columnDefinition = "INT")
    private Integer weakFoot;

    @Column(name = "skill_moves", nullable = false, columnDefinition = "INT")
    private Integer skillMoves;
}
