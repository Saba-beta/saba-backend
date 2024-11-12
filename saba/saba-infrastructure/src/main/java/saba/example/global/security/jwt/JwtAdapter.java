package saba.example.global.security.jwt;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.Adapter;
import saba.example.domain.auth.dto.response.TokenResponseApp;
import saba.example.domain.auth.model.Authority;
import saba.example.domain.auth.spi.JwtPort;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Adapter
public class JwtAdapter implements JwtPort {
    private final JwtProperties jwtProperties;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * @return refresh 토큰 만료 시간
     */
    @Override
    public LocalDateTime getRefreshExpExpiredAt() {
        return LocalDateTime.now().plusSeconds(jwtProperties.getRefreshExp());

    }

    @Override
    public TokenResponseApp createToken(String userId, Authority authority) {
        return jwtTokenProvider.createToken(userId, authority);
    }
}
