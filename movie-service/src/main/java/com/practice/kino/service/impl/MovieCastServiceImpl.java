package com.practice.kino.service.impl;

import com.practice.kino.dto.request.AddMovieCastRequest;
import com.practice.kino.dto.request.DeleteMovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;
import com.practice.kino.entity.MovieCast;
import com.practice.kino.mapper.MovieCastMapper;
import com.practice.kino.repository.MovieCastRepository;
import com.practice.kino.service.MovieCastService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieCastServiceImpl implements MovieCastService {

    private MovieCastRepository movieCastRepository;
    private MovieCastMapper movieCastMapper;

    @Override
    public void addMovieCast(AddMovieCastRequest request) {
        movieCastRepository.save(movieCastMapper.toEntity(request));
    }

    @Override
    public void deleteMovieCast(DeleteMovieCastRequest request) {
        MovieCast movieCast = movieCastRepository.findByMovie_IdAndActor_Id(request.movie_id(), request.actor_id());
        movieCastRepository.delete(movieCast);
    }

    @Override
    public List<PeopleOfMovieReadResponse> findAllPeopleOfMovieByMovieId(UUID movieId, Optional<Integer> limit) {
        List<MovieCast> list = movieCastRepository.findAllByMovie_Id(movieId, Limit.of(limit.orElse(10)));
        return list.stream().map(movieCastMapper::toPeopleOfMovieReadResponse).collect(Collectors.toList());
    }

    @Override
    public List<MoviesOfPersonReadResponse> findAllMoviesOfPersonByPersonId(UUID personId, Optional<Integer> limit) {
        List<MovieCast> list = movieCastRepository.findAllByActor_Id(personId, Limit.of(limit.orElse(10)));
        return list.stream().map(movieCastMapper::toMoviesOfPersonReadResponse).collect(Collectors.toList());
    }
}
