package com.example.diplomaprojectbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Favorites")
@Data
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "liker_user_id", nullable = false, referencedColumnName = "id")
    private User liker;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "liked_user_id", nullable = false, referencedColumnName = "id")
    private User liked;
}
