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

    @ManyToOne
    @JoinColumn(name = "liker_user_id", nullable = false, referencedColumnName = "id")
    private User liker;

    @ManyToOne
    @JoinColumn(name = "liked_user_id", nullable = false, referencedColumnName = "id")
    private User liked;
}
