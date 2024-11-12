package saba.example.domain.auth.spi;

import saba.example.domain.auth.dto.response.TokenResponseApp;
import saba.example.domain.auth.model.Authority;

import java.time.LocalDateTime;

public interface JwtPort {
    LocalDateTime getRefreshExpExpiredAt();

    TokenResponseApp createToken(String userId, Authority authority);
}
