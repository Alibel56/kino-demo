package com.practice.kino.repository;

import com.practice.kino.entity.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, UUID> {
}
