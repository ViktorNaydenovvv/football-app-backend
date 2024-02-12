package com.example.diplomaprojectbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Goalkeepers")
@Data
public class Goalkeeper {
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

    @Column(name = "diving", nullable = false, columnDefinition = "INT")
    private Integer diving;

    @Column(name = "handling", nullable = false, columnDefinition = "INT")
    private Integer handling;

    @Column(name = "kicking", nullable = false, columnDefinition = "INT")
    private Integer kicking;

    @Column(name = "reflex", nullable = false, columnDefinition = "INT")
    private Integer reflex;

    @Column(name = "speed", nullable = false, columnDefinition = "INT")
    private Integer speed;

    @Column(name = "positioning", nullable = false, columnDefinition = "INT")
    private Integer positioning;

    @Column(name = "weak_foot", nullable = false, columnDefinition = "INT")
    private Integer weakFoot;

    @Column(name = "skill_moves", nullable = false, columnDefinition = "INT")
    private Integer skillMoves;
}
