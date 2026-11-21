package com.practice.kino.mapper;

import com.practice.kino.dto.request.AddMovieCastRequest;
import com.practice.kino.dto.response.MoviesOfPersonReadResponse;
import com.practice.kino.dto.response.PeopleOfMovieReadResponse;
import com.practice.kino.entity.MovieCast;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MovieCastMapper {

    @Mapping(target = "id", ignore = true)
    MovieCast toEntity(AddMovieCastRequest movieCastRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "actor.firstName", target = "firstName")
    @Mapping(source = "actor.lastName", target = "lastName")
    @Mapping(source = "role", target = "role")
    PeopleOfMovieReadResponse toPeopleOfMovieReadResponse(MovieCast movieCast);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "movie.title", target = "title")
    @Mapping(source = "movie.releaseDate", target = "releaseDate")
    MoviesOfPersonReadResponse toMoviesOfPersonReadResponse(MovieCast movieCast);
}
