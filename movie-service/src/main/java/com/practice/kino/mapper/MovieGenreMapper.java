package com.practice.kino.mapper;

import com.practice.kino.dto.request.MovieGenreRequest;
import com.practice.kino.dto.response.GenresOfMovieReadResponse;
import com.practice.kino.dto.response.MoviesOfGenreReadResponse;
import com.practice.kino.entity.MovieGenre;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MovieGenreMapper {

    @Mapping(target = "id", ignore = true)
    MovieGenre toEntity(MovieGenreRequest movieGenreRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "genre.title", target = "title")
    GenresOfMovieReadResponse toGenresOfMovieReadResponse(MovieGenre movieGenre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "movie.title", target = "title")
    @Mapping(source = "movie.releaseDate", target = "releaseDate")
    MoviesOfGenreReadResponse toMoviesOfGenreReadResponse(MovieGenre movieGenre);
}
