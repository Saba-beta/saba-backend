package saba.example.domain.auth.spi;

import saba.example.domain.auth.dto.response.TokenResponse;
import saba.example.domain.auth.model.type.Authority;

import java.time.LocalDateTime;

public interface JwtPort {
    LocalDateTime getRefreshExpExpiredAt();

    TokenResponse createToken(String userId, Authority authority);
}
