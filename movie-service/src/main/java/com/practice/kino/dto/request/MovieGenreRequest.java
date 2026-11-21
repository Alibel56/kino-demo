package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MovieGenreRequest(
        @NotNull(message = "You should have a movie to add/delete")
        UUID movieId,

        @NotNull(message = "You should have a genre to add/delete")
        UUID genreId
) {}
