package com.practice.kino.repository;

import com.practice.kino.entity.MovieCast;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieCastRepository extends JpaRepository<MovieCast, UUID> {
    MovieCast findByMovie_IdAndActor_Id(UUID movieId, UUID actorId);
    List<MovieCast> findAllByMovie_Id(UUID movieId, Limit limit);
    List<MovieCast> findAllByActor_Id(UUID actorId, Limit limit);
}
