package com.practice.kino.mapper;

import com.practice.kino.dto.request.RegisterRequest;
import com.practice.kino.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password_hashed", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "created_at", ignore = true)
    @Mapping(target = "updated_at", ignore = true)
    @Mapping(target = "bio", ignore = true)
    AuthUser toEntity(RegisterRequest request);
}
