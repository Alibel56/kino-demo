package com.practice.kino.dto.request;

import java.time.LocalDate;
import java.util.List;

public record MovieFilterRequest(
        String title,
        LocalDate releaseDateFrom,
        LocalDate releaseDateTo,
        String releaseCountry,
        List<String> genreList,
        List<String> castList,
        SortingType sortingType
) {}
