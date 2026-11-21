package com.practice.kino.service;

import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.UpdateProfileRequest;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserProfile;

import java.util.UUID;

public interface UserProfileService {
    ProfileReadResponse createUserProfile(CreateUserRequest request);
    void updateUserProfile(UUID id, UpdateProfileRequest request);
    void deleteUserProfile(UUID id);
    ProfileReadResponse findById(UUID id);
    UserProfile findProfileById(UUID id);
}
