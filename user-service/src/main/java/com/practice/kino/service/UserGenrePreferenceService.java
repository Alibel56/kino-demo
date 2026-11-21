package com.practice.kino.service;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.entity.UserGenrePreference;

import java.util.Set;
import java.util.UUID;

public interface UserGenrePreferenceService {
    void addUserGenrePreference(AddGenreRequest request);
    Set<UserGenrePreference> findByUserId(UUID id);
    void deleteUserGenrePreference(UUID id);
}
