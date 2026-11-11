package com.practice.kino.mapper;

import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.UpdateProfileRequest;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserProfile;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    @Mapping(target = "avatar_url", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "bio", ignore = true)
    @Mapping(target = "genrePreferences", ignore = true)
    UserProfile toEntity(CreateUserRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProfileReadResponse toResponse(UserProfile userProfile);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(
            UpdateProfileRequest request,
            @MappingTarget UserProfile profile
    );

}
