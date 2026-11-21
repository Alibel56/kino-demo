package com.practice.kino.service;


import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieGenreService {
    void addMovieGenre(MovieGenreRequest request);
    void deleteMovieGenre(MovieGenreRequest request);
    List<GenresOfMovieReadResponse> findAllGenresOfMovieByMovieId(UUID movieId, Optional<Integer> limit);
    List<MoviesOfGenreReadResponse> findAllMoviesOfGenreByGenreId(UUID genreId, Optional<Integer> limit);
}
