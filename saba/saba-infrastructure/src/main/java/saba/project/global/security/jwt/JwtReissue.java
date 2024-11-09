package saba.project.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saba.example.domain.auth.dto.TokenResponse;
import saba.example.domain.auth.model.Authority;
import saba.project.global.security.auth.AuthDetailsService;
import saba.example.domain.auth.exception.InvalidTokenException;
import saba.example.domain.auth.exception.NotRefreshTokenException;

@RequiredArgsConstructor
@Service
@Transactional
public class JwtReissue {
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponse reissue(String refreshToken, Authority authority) {

        if(!isRefreshToken(refreshToken)) {
            throw new NotRefreshTokenException();
        }

        String accountId = getId(refreshToken);

        return TokenResponse.builder()
                // 토큰 제작
                .accessToken(jwtTokenProvider.createAccessToken(accountId, authority))
                .refreshToken(refreshToken)
                .build();
    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (InvalidTokenException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private boolean isRefreshToken(String token) { // refresh 토큰인지 확인
        return getClaims(token).get("type").equals("refresh");
    }

    public Authentication getAuthentication(String token) { // 토큰 유효성 확인
        Claims claims = getClaims(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

}
