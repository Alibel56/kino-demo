package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeleteMovieCastRequest(
        @NotNull(message = "You should have a movie to delete")
        UUID movie_id,

        @NotNull(message = "You should have an actor to delete")
        UUID actor_id
) {}
