package com.practice.kino.service;


import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;

import java.util.List;
import java.util.UUID;

public interface MovieGenreService {
    public void addMovieCast(MovieGenreRequest request);
    public void deleteMovieCast(MovieGenreRequest request);
    public List<GenresOfMovieReadResponse> findAllGenresOfMovieByMovieId(UUID movieId);
    public List<MoviesOfGenreReadResponse> findAllMoviesOfGenreByGenreId(UUID genreId);
}
