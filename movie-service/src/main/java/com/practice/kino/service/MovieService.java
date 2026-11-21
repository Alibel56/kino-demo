package com.practice.kino.service;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.MovieFilterRequest;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    void addMovie(AddMovieRequest request);
    void updateMovie(UUID movieId, UpdateMovieRequest request);
    void deleteMovie(UUID movieId);
    MovieReadResponse findMovieById(UUID movieId);
    List<MovieReadResponse> findAllMoviesByFilter(MovieFilterRequest request);
}
