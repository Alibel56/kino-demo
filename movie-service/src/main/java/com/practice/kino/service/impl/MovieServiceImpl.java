package com.practice.kino.service.impl;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.MovieFilterRequest;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;
import com.practice.kino.repository.MovieRepository;
import com.practice.kino.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public void addMovie(AddMovieRequest request) {

    }

    @Override
    public void updateMovie(UpdateMovieRequest request) {

    }

    @Override
    public void deleteMovie(UUID movieId) {

    }

    @Override
    public MovieReadResponse findMovieById(UUID movieId) {
        return null;
    }

    @Override
    public List<MovieReadResponse> findAllMoviesByFilter(MovieFilterRequest request) {
        return List.of();
    }
}
