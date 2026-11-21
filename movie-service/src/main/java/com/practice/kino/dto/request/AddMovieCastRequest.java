package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AddMovieCastRequest(
        @NotNull(message = "You should have a movie to add")
        UUID movie_id,

        @NotNull(message = "You should have an actor to add")
        UUID actor_id,

        @NotNull(message = "Actor should have a role ")
        String role
) {}
