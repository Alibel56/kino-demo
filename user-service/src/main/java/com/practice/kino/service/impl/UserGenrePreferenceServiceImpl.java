package com.practice.kino.service.impl;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.entity.UserGenrePreference;
import com.practice.kino.entity.UserProfile;
import com.practice.kino.repository.UserGenrePreferenceRepository;
import com.practice.kino.service.UserGenrePreferenceService;
import com.practice.kino.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGenrePreferenceServiceImpl implements UserGenrePreferenceService {

    private final UserGenrePreferenceRepository userGenrePreferenceRepository;
    private final UserProfileService userProfileService;

    @Override
    public void addUserGenrePreference(AddGenreRequest request) {
        UserProfile profile = userProfileService.findProfileById(request.userId());

        UserGenrePreference userGenrePreference = new UserGenrePreference();
        userGenrePreference.setUserProfile(profile);
        userGenrePreference.setGenreId(request.genreId());

        profile.addUserGenrePreference(userGenrePreference);

        userGenrePreferenceRepository.save(userGenrePreference);
    }

    @Override
    public Set<UserGenrePreference> findByUserId(UUID id) {
        UserProfile profile = userProfileService.findProfileById(id);
        return profile.getGenrePreferences();
    }

    @Override
    public void deleteUserGenrePreference(UUID id) {
        userGenrePreferenceRepository.deleteById(id);
    }
}
