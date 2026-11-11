package com.practice.kino.dto.response;

import com.practice.kino.entity.UserBio;
import com.practice.kino.entity.UserGenrePreference;

import java.time.LocalDate;
import java.util.Set;

public record ProfileReadResponse(
        String firstName,
        String lastName,
        String avatar_url,
        LocalDate birthDate,
        UserBio bio,
        Set<UserGenrePreference> genrePreferences
) {}
