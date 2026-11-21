package com.practice.kino.mapper;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.dto.response.GenreReadResponse;
import com.practice.kino.entity.Genre;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movieGenres", ignore = true)
    Genre toEntity(AddGenreRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    GenreReadResponse toResponse(Genre genre);
}
