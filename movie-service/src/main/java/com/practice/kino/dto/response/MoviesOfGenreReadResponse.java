package com.practice.kino.dto.response;

import java.time.LocalDate;

public record MoviesOfGenreReadResponse(
        String title,
        LocalDate releaseDate
) {}
