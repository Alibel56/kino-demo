package com.practice.kino.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RatingReadResponse(
        String title,
        LocalDate releaseDate,
        Double rating
) {}
