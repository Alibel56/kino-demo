package com.practice.kino.service;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.response.GenreReadResponse;

import java.util.UUID;

public interface GenreService {

    public void addGenre(AddGenreRequest request);
    public void deleteGenre(UUID genreId);
    public GenreReadResponse findGenreById(UUID genreId);
}
