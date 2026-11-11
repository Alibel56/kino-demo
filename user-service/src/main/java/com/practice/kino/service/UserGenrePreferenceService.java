package com.practice.kino.service;

import com.practice.kino.dto.request.AddGenreRequest;
import com.practice.kino.entity.UserGenrePreference;

import java.util.Set;
import java.util.UUID;

public interface UserGenrePreferenceService {
    public void addUserGenrePreference(AddGenreRequest request);
    public Set<UserGenrePreference> findByUserId(UUID id);
    public void deleteUserGenrePreference(UUID id);
}
