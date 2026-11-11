package com.practice.kino.mapper;

import com.practice.kino.dto.request.UpdateBioRequest;
import com.practice.kino.dto.response.BioReadResponse;
import com.practice.kino.entity.UserBio;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserBioMapper {
    void updateEntity(
            UpdateBioRequest request,
            @MappingTarget UserBio bio
    );

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BioReadResponse toResponse(UserBio userBio);
}
