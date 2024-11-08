package saba.example.domain.auth.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final LocalDateTime accessExpiresTime;
    private final String refreshToken;
    private final LocalDateTime refreshExpiresTime;
}
