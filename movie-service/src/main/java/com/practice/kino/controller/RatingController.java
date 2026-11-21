package com.practice.kino.controller;

import com.practice.kino.dto.response.RatingReadResponse;
import com.practice.kino.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/rating/{movieId}")
    public ResponseEntity<RatingReadResponse> getRatingByMovieId(
            @PathVariable UUID movieId
    ){
        return ResponseEntity.ok(ratingService.findRatingByMovieId(movieId));
    }
}
