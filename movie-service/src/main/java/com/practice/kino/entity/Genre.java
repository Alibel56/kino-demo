package com.practice.kino.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "genres", schema = "movie")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "genre_title", nullable = false)
    private String title;

    @Column(name = "genre_description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "genres")
    private Set<MovieGenre> movieGenres = new HashSet<>();
}
