package com.practice.kino.service.impl;

import com.practice.kino.dto.request.UpdateBioRequest;
import com.practice.kino.dto.response.BioReadResponse;
import com.practice.kino.dto.response.ProfileReadResponse;
import com.practice.kino.entity.UserBio;
import com.practice.kino.entity.UserProfile;
import com.practice.kino.mapper.UserBioMapper;
import com.practice.kino.repository.UserBioRepository;
import com.practice.kino.service.UserBioService;
import com.practice.kino.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserBioServiceImpl implements UserBioService {

    private final UserBioRepository userBioRepository;
    private final UserBioMapper userBioMapper;
    private final UserProfileService userProfileService;

    @Override
    public void updateUserBio(UUID id, UpdateBioRequest request) {
        UserProfile profile = userProfileService.findProfileById(id);
        UserBio userBio = profile.getBio();

        userBioMapper.updateEntity(request, profile.getBio());
        userBioRepository.save(userBio);
    }

    @Override
    public BioReadResponse findByUserId(UUID id) {
        ProfileReadResponse profile = userProfileService.findById(id);
        return userBioMapper.toResponse(profile.bio());
    }

    @Override
    public BioReadResponse findById(UUID id) {
        UserBio userBio = userBioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserBio not found"));

        return userBioMapper.toResponse(userBio);
    }
}
