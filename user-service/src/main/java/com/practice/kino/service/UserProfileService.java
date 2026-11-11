package com.practice.kino.service;

import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.UpdateProfileRequest;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserProfile;

import java.util.UUID;

public interface UserProfileService {
    public ProfileReadResponse createUserProfile(CreateUserRequest request);
    public void updateUserProfile(UUID id, UpdateProfileRequest request);
    public void deleteUserProfile(UUID id);
    public ProfileReadResponse findById(UUID id);
    public UserProfile findProfileById(UUID id);
}
