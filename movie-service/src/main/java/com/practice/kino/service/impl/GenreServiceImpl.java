package com.practice.kino.service.impl;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.response.GenreReadResponse;
import com.practice.kino.mapper.GenreMapper;
import com.practice.kino.repository.GenreRepository;
import com.practice.kino.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;
    private GenreMapper genreMapper;

    @Override
    public void addGenre(AddGenreRequest request) {
        genreRepository.save(genreMapper.toEntity(request));
    }

    @Override
    public void deleteGenre(UUID genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    public GenreReadResponse findGenreById(UUID genreId) {
        return genreMapper.toResponse(genreRepository.findByGenreId(genreId));
    }
}
