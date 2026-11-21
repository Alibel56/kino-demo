package com.practice.kino.dto.response;

import java.time.LocalDate;

public record MoviesOfPersonReadResponse(
        String title,
        LocalDate releaseDate
) {}
