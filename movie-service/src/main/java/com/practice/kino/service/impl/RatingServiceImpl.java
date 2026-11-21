package com.practice.kino.service.impl;

import com.practice.kino.dto.response.RatingReadResponse;
import com.practice.kino.entity.Rating;
import com.practice.kino.mapper.RatingMapper;
import com.practice.kino.repository.RatingRepository;
import com.practice.kino.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private RatingMapper ratingMapper;

    @Override
    public RatingReadResponse findRatingByMovieId(UUID movieId) {
        Rating rating = ratingRepository.findByMovieId(movieId);
        return ratingMapper.toRatingReadResponse(rating);
    }
}
