package com.practice.kino.service.impl;

import com.practice.kino.dto.request.CreateUserRequest;
import com.practice.kino.dto.request.UpdateProfileRequest;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserProfile;
import com.practice.kino.mapper.UserProfileMapper;
import com.practice.kino.repository.UserProfileRepository;
import com.practice.kino.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    public ProfileReadResponse createUserProfile(CreateUserRequest request) {
        UserProfile userProfile = userProfileMapper.toEntity(request);
        userProfileRepository.save(userProfile);

        return userProfileMapper.toResponse(userProfile);
    }

    @Override
    public void updateUserProfile(UUID id, UpdateProfileRequest request) {
        UserProfile profile = userProfileRepository.findById(id).
                orElseThrow(() -> new RuntimeException("UserProfile Not Found"));

        userProfileMapper.updateEntity(request, profile);
        userProfileRepository.save(profile);
    }

    @Override
    public void deleteUserProfile(UUID id) {
        userProfileRepository.deleteById(id);
    }

    @Override
    public ProfileReadResponse findById(UUID id) {
        UserProfile profile = userProfileRepository.findById(id).
                orElseThrow(() -> new RuntimeException("UserProfile Not Found"));

        return userProfileMapper.toResponse(profile);
    }

    @Override
    public UserProfile findProfileById(UUID id) {
        return userProfileRepository.findById(id).
                orElseThrow(() -> new RuntimeException("UserProfile Not Found"));
    }

}
