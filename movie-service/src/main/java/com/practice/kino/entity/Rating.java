package com.practice.kino.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "rating", schema = "movie")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Movie movie;

    @Column(name = "avg_rating", nullable = false)
    private Long rating;
}
