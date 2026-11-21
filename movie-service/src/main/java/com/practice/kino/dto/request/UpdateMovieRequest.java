package com.practice.kino.dto.request;

import com.practice.kino.entity.Rating;

public record UpdateMovieRequest(
        String url,
        Rating rating
) {}
