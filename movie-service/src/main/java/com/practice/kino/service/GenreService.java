package com.practice.kino.service;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.response.GenreReadResponse;

import java.util.UUID;

public interface GenreService {

    void addGenre(AddGenreRequest request);
    void deleteGenre(UUID genreId);
    GenreReadResponse findGenreById(UUID genreId);
}
