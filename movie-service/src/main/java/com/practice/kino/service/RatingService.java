package com.practice.kino.service;

import com.practice.kino.dto.response.RatingReadResponse;

import java.util.UUID;

public interface RatingService {
    RatingReadResponse findRatingByMovieId(UUID movieId);
}
