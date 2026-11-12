package com.practice.kino.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "profile", schema = "user")
public class UserProfile  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String avatar_url;

    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(
            mappedBy = "userProfile",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private UserBio bio;

    @OneToMany(mappedBy = "userProfile")
    private Set<UserGenrePreference> genrePreferences = new HashSet<>();

    public void addUserGenrePreference(UserGenrePreference userGenrePreference) {
        genrePreferences.add(userGenrePreference);
    }
}
