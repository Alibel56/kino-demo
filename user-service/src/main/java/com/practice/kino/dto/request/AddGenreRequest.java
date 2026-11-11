package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AddGenreRequest(
        @NotNull
        UUID userId,
        @NotNull
        UUID genreId
) {}
