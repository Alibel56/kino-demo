package com.practice.kino.service.impl;

import com.practice.kino.dto.request.RatingFilterRequest;
import com.practice.kino.dto.response.RatingReadResponse;
import com.practice.kino.repository.RatingRepository;
import com.practice.kino.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    @Override
    public RatingReadResponse findRatingByMovieId(UUID movieId) {
        return null;
    }

    @Override
    public List<RatingReadResponse> findAllRatingsByFilter(RatingFilterRequest request) {
        return List.of();
    }
}
