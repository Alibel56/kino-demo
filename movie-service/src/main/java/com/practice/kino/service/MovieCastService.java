package com.practice.kino.service;

import com.practice.kino.dto.request.MovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;

import java.util.List;
import java.util.UUID;

public interface MovieCastService {

    public void addMovieCast(MovieCastRequest request);
    public void deleteMovieCast(MovieCastRequest request);
    public List<PeopleOfMovieReadResponse> findAllPeopleOfMovieByMovieId(UUID movieId);
    public List<MoviesOfPersonReadResponse> findAllMoviesOfPersonByPersonId(UUID personId);
}
