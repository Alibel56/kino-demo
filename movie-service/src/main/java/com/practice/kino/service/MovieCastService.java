package com.practice.kino.service;

import com.practice.kino.dto.request.AddMovieCastRequest;
import com.practice.kino.dto.request.DeleteMovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieCastService {

    void addMovieCast(AddMovieCastRequest request);
    void deleteMovieCast(DeleteMovieCastRequest request);
    List<PeopleOfMovieReadResponse> findAllPeopleOfMovieByMovieId(UUID movieId, Optional<Integer> limit);
    List<MoviesOfPersonReadResponse> findAllMoviesOfPersonByPersonId(UUID personId, Optional<Integer> limit);
}
