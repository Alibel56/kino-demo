package com.practice.kino.controller;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.MovieFilterRequest;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;
import com.practice.kino.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/video")
    public ResponseEntity<HttpStatus> addMovie(
            @Valid @RequestBody AddMovieRequest request
    ){
        movieService.addMovie(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/video/{movieId}")
    public ResponseEntity<HttpStatus> updateMovie(
            @PathVariable UUID movieId,
            @Valid @RequestBody UpdateMovieRequest request
    ){
        movieService.updateMovie(movieId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/video/{movieId}")
    public ResponseEntity<HttpStatus> deleteMovie(
            @PathVariable UUID movieId
    ){
        movieService.deleteMovie(movieId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/video/{movieId}")
    public ResponseEntity<MovieReadResponse> getMovie(
            @PathVariable UUID movieId
    ){
        return ResponseEntity.ok(movieService.findMovieById(movieId));
    }

    @GetMapping("/video")
    public ResponseEntity<List<MovieReadResponse>> getAllMoviesByFilter(
            @Valid @RequestBody MovieFilterRequest request
    ){
        return ResponseEntity.ok(movieService.findAllMoviesByFilter(request));
    }
}
