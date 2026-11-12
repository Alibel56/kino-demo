package com.practice.kino.service;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.MovieFilterRequest;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    public void addMovie(AddMovieRequest request);
    public void updateMovie(UpdateMovieRequest request);
    public void deleteMovie(UUID movieId);
    public MovieReadResponse findMovieById(UUID movieId);
    public List<MovieReadResponse> findAllMoviesByFilter(MovieFilterRequest request);
}
