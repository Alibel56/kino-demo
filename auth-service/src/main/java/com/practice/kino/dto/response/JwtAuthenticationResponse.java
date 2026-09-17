package com.practice.kino.dto.response;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record JwtAuthenticationResponse (
        String token,
        String refreshToken
){}
