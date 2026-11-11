package com.practice.kino.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateBioRequest(
        @NotBlank
        String bio
) {}
