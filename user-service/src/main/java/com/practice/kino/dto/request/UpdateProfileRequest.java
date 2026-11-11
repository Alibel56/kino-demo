package com.practice.kino.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UpdateProfileRequest(
        String firstName,
        String lastName,
        String avatar_url,
        LocalDate birthDate,
        String bio
) {}
