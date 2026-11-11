package com.practice.kino.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterRequest(
        @NotBlank(message = "Name is required!")
        String firstName,

        @NotBlank(message = "Surname is required!")
        String lastName,

        @NotBlank(message = "Email is required!")
        @Email
        String email,

        @NotBlank(message = "Password is required!")
        @Size(
                min = 8, max = 20,
                message = "Password length must be between 8 and 20 characters!"
        )
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$",
                message = "Password must contain letters and numbers!"
        )
        String password
) {
}
