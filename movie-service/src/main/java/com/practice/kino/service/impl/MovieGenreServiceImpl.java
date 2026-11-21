package com.practice.kino.service.impl;

import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;
import com.practice.kino.entity.MovieGenre;
import com.practice.kino.mapper.MovieGenreMapper;
import com.practice.kino.repository.MovieGenreRepository;
import com.practice.kino.service.MovieGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieGenreServiceImpl implements MovieGenreService {

    private MovieGenreRepository movieGenreRepository;
    private MovieGenreMapper movieGenreMapper;

    @Override
    public void addMovieGenre(MovieGenreRequest request) {
        movieGenreRepository.save(movieGenreMapper.toEntity(request));
    }

    @Override
    public void deleteMovieGenre(MovieGenreRequest request) {
        MovieGenre movieGenre = movieGenreRepository.findByMovie_IdAndGenre_Id(request.movieId(), request.genreId());
        movieGenreRepository.delete(movieGenre);
    }

    @Override
    public List<GenresOfMovieReadResponse> findAllGenresOfMovieByMovieId(UUID movieId, Optional<Integer> limit) {
        List<MovieGenre> list = movieGenreRepository.findAllByMovie_Id(movieId, Limit.of(limit.orElse(10)));
        return list.stream().map(movieGenreMapper::toGenresOfMovieReadResponse).collect(Collectors.toList());
    }

    @Override
    public List<MoviesOfGenreReadResponse> findAllMoviesOfGenreByGenreId(UUID genreId, Optional<Integer> limit) {
        List<MovieGenre> list = movieGenreRepository.findAllByGenre_Id(genreId, Limit.of(limit.orElse(10)));
        return list.stream().map(movieGenreMapper::toMoviesOfGenreReadResponse).collect(Collectors.toList());
    }
}
