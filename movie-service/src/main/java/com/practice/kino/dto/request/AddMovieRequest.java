package com.practice.kino.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AddMovieRequest(
        @NotBlank(message = "Movie should has a title")
        String title,

        @NotBlank(message = "Movie should has a overview")
        String overview,

        @Min(value = 0, message = "Movie should has a time")
        Integer time,

        @NotBlank(message = "Movie should has a url")
        String url,

        @NotNull(message = "Movie should has a releaseDate")
        LocalDate releaseDate,

        @NotBlank(message = "Movie should has a releaseCountry")
        String releaseCountry
) {}
