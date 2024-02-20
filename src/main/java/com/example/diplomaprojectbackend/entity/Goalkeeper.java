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

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "diving", nullable = false)
    private Integer diving;

    @Column(name = "handling", nullable = false)
    private Integer handling;

    @Column(name = "kicking", nullable = false)
    private Integer kicking;

    @Column(name = "reflex", nullable = false)
    private Integer reflex;

    @Column(name = "speed", nullable = false)
    private Integer speed;

    @Column(name = "positioning", nullable = false)
    private Integer positioning;}
