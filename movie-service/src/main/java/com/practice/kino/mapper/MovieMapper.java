package com.practice.kino.mapper;

import com.practice.kino.dto.request.AddMovieRequest;
import com.practice.kino.dto.request.UpdateMovieRequest;
import com.practice.kino.dto.response.MovieReadResponse;
import com.practice.kino.entity.Movie;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movieGenres", ignore = true)
    @Mapping(target = "movieCasts", ignore = true)
    @Mapping(target = "rating", ignore = true)
    Movie toEntity(AddMovieRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "title", target = "title")
    @Mapping(source = "overview", target = "overview")
    @Mapping(source = "time", target = "time")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "releaseCountry", target = "releaseCountry")
    @Mapping(source = "movieGenres", target = "genresList")
    @Mapping(source = "movieCasts", target = "actorsList")
    @Mapping(source = "rating.rating", target = "rating")
    MovieReadResponse toResponse(Movie movie);

    void updateEntity(
            UpdateMovieRequest request,
            @MappingTarget Movie movie
    );
}
