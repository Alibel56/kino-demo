package com.practice.kino.dto.request;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateUserRequest(
        UUID id,
        String firstName,
        String lastName
) {}
