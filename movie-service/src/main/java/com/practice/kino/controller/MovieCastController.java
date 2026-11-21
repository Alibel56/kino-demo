package com.practice.kino.controller;

import com.practice.kino.dto.request.AddMovieCastRequest;
import com.practice.kino.dto.request.DeleteMovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;
import com.practice.kino.service.MovieCastService;
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
public class MovieCastController {

    private final MovieCastService movieCastService;

    @PostMapping("/movie-cast")
    public ResponseEntity<HttpStatus> addMovieCast(
            @Valid @RequestBody AddMovieCastRequest request
    ){
        movieCastService.addMovieCast(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/movie-cast")
    public ResponseEntity<HttpStatus> deleteMovieCast(
            @Valid @RequestBody DeleteMovieCastRequest request
    ){
        movieCastService.deleteMovieCast(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/movie-cast/{movieId}")
    public ResponseEntity<List<PeopleOfMovieReadResponse>> getAllPeopleOfMovieByMovieId(
            @PathVariable UUID movieId,
            @RequestParam(required = false) Integer limit
    ){
        return ResponseEntity.ok(
                movieCastService.findAllPeopleOfMovieByMovieId(movieId, Optional.ofNullable(limit))
        );
    }

    @GetMapping("/movie-cast/{personId}")
    public ResponseEntity<List<MoviesOfPersonReadResponse>> getAllMoviesOfPersonByPersonId(
            @PathVariable UUID personId,
            @RequestParam(required = false) Integer limit
    ) {
        return ResponseEntity.ok(
                movieCastService.findAllMoviesOfPersonByPersonId(personId, Optional.ofNullable(limit))
        );
    }
}
