package dto.response;

import lombok.Builder;

@Builder
public record LoginResponse(
        String token,
        String tokenType,
        long expiresInSeconds
) {}

