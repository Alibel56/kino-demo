package com.practice.kino.controller;

import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;
import com.practice.kino.service.MovieGenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieGenreController {

    private final MovieGenreService movieGenreService;

    @PostMapping("movie-genre")
    public ResponseEntity<HttpStatus> addMovieGenre(
            @Valid @RequestBody MovieGenreRequest request
    ){
        movieGenreService.addMovieGenre(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("movie-genre")
    public ResponseEntity<HttpStatus> deleteMovieGenre(
            @Valid @RequestBody MovieGenreRequest request
    ){
        movieGenreService.deleteMovieGenre(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("movie-genre/{movieId}")
    public ResponseEntity<List<GenresOfMovieReadResponse>> getAllGenresOfMovieByMovieId(
            @PathVariable UUID movieId,
            @RequestParam(required = false) Integer limit
    ){
        return ResponseEntity.ok(
                movieGenreService.findAllGenresOfMovieByMovieId(movieId, Optional.ofNullable(limit))
        );
    }

    @GetMapping("movie-genre/{genreId}")
    public ResponseEntity<List<MoviesOfGenreReadResponse>> getAllMoviesOfGenreByGenreId(
            @PathVariable UUID genreId,
            @RequestParam(required = false) Integer limit
    ){
        return ResponseEntity.ok(
                movieGenreService.findAllMoviesOfGenreByGenreId(genreId, Optional.ofNullable(limit))
        );
    }
}
