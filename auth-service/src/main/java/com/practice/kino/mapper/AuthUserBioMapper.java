package com.practice.kino.mapper;

import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.entity.AuthUserBio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthUserBioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authUser", ignore = true)
    @Mapping(target = "created_at", ignore = true)
    @Mapping(target = "updated_at", ignore = true)
    AuthUserBio toEntity(RegisterRequest request);
}
