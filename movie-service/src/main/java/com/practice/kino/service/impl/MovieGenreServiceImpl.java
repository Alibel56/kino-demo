package com.practice.kino.service.impl;

import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;
import com.practice.kino.repository.MovieGenreRepository;
import com.practice.kino.service.MovieGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieGenreServiceImpl implements MovieGenreService {

    private MovieGenreRepository movieGenreRepository;

    @Override
    public void addMovieCast(MovieGenreRequest request) {

    }

    @Override
    public void deleteMovieCast(MovieGenreRequest request) {

    }

    @Override
    public List<GenresOfMovieReadResponse> findAllGenresOfMovieByMovieId(UUID movieId) {
        return List.of();
    }

    @Override
    public List<MoviesOfGenreReadResponse> findAllMoviesOfGenreByGenreId(UUID genreId) {
        return List.of();
    }
}
