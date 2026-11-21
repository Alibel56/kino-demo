package com.practice.kino.dto.response;

import java.time.LocalDate;
import java.util.List;


public record MovieReadResponse(
        String title,

        String overview,

        Integer time,

        String url,

        LocalDate releaseDate,

        String releaseCountry,

        List<GenreReadResponse> genresList,

        List<PersonReadResponse> actorsList,

        Double rating
) {}
