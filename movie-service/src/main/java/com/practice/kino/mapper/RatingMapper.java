package com.practice.kino.mapper;

import com.practice.kino.dto.response.RatingReadResponse;
import com.practice.kino.entity.Rating;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "movie.title", target = "title")
    @Mapping(source = "movie.releaseDate", target = "releaseDate")
    @Mapping(source = "rating", target = "rating")
    RatingReadResponse toRatingReadResponse(Rating rating);
}
