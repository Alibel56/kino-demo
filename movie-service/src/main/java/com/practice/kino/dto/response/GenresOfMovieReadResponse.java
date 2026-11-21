package com.practice.kino.dto.response;

import lombok.Builder;

@Builder
public record GenresOfMovieReadResponse(
        String title
) {}
