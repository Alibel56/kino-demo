package com.practice.kino.mapper;


import com.practice.kino.dto.request.PersonRequest;
import com.practice.kino.dto.response.PersonReadResponse;
import com.practice.kino.entity.Person;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movieCasts", ignore = true)
    Person toEntity(PersonRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PersonReadResponse toResponse(Person person);

    void updateEntity(
            PersonRequest request,
            @MappingTarget Person person
    );
}
