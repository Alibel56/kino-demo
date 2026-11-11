package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateUserRequest(
        @NotNull
        UUID id,

        @NotBlank(message = "User must have a first name!")
        String firstName,

        @NotBlank(message = "User must have a last name!")
        String lastName
) {}
