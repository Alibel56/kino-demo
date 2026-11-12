package com.practice.kino.service.impl;

import com.practice.kino.dto.request.MovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;
import com.practice.kino.repository.MovieCastRepository;
import com.practice.kino.service.MovieCastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieCastServiceImpl implements MovieCastService {

    private MovieCastRepository movieCastRepository;

    @Override
    public void addMovieCast(MovieCastRequest request) {

    }

    @Override
    public void deleteMovieCast(MovieCastRequest request) {

    }

    @Override
    public List<PeopleOfMovieReadResponse> findAllPeopleOfMovieByMovieId(UUID movieId) {
        return List.of();
    }

    @Override
    public List<MoviesOfPersonReadResponse> findAllMoviesOfPersonByPersonId(UUID personId) {
        return List.of();
    }
}
