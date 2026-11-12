package com.practice.kino.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "people", schema = "movie")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "actor_first_name", nullable = false)
    private String firstName;

    @Column(name = "actor_last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "actor_gender", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "actors")
    private Set<MovieCast> movieCasts = new HashSet<>();

}
