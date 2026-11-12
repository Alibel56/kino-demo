package com.practice.kino.service;

import com.practice.kino.dto.request.RatingFilterRequest;
import com.practice.kino.dto.response.RatingReadResponse;

import java.util.List;
import java.util.UUID;

public interface RatingService  {

    public RatingReadResponse findRatingByMovieId(UUID movieId);
    public List<RatingReadResponse> findAllRatingsByFilter(RatingFilterRequest request);
}
