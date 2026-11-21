package com.practice.kino.repository;

import com.practice.kino.entity.MovieGenre;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, UUID> {
    MovieGenre findByMovie_IdAndGenre_Id(UUID movieId, UUID genreId);
    List<MovieGenre> findAllByMovie_Id(UUID movieId, Limit limit);
    List<MovieGenre> findAllByGenre_Id(UUID genreId, Limit limit);

}
