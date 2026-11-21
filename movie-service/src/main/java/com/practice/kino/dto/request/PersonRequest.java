package com.practice.kino.dto.request;

import com.practice.kino.entity.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PersonRequest(
        @NotBlank(message = "Person should has a first name")
        String firstName,

        @NotBlank(message = "Person should has a last name")
        String lastName,

        @NotNull(message = "Person should has a birth day")
        LocalDate birthDate,

        @NotNull(message = "Person should has a gender")
        Gender gender
) {}
