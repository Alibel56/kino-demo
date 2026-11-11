package com.practice.kino.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RegisterResponse(
        UUID userId,
        String accessToken
) {}
