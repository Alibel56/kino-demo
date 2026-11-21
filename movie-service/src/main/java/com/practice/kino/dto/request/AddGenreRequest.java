package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddGenreRequest(
        @NotBlank(message = "Genre must has a title")
        String title,

        @NotBlank(message = "Genre must has a description")
        String description
) {}
