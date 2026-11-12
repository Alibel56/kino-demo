package com.practice.kino.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "movies", schema = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "movie_title", nullable = false)
    private String title;

    @Column(name = "movie_overview", nullable = false)
    private String overview;

    @Column(name = "movie_time_in_seconds", nullable = false)
    private Integer time;

    @Column(name = "movie_url", nullable = false, unique = true)
    private String url;

    @Column(name = "movie_release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "movie_release_country", nullable = false)
    private String releaseCountry;

    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<MovieGenre> movieGenres = new HashSet<>();

    @OneToMany(mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<MovieCast> movieCasts = new HashSet<>();

    @OneToOne(mappedBy = "movie")
    private Rating rating;

}
