package saba.project.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import saba.project.global.security.auth.domain.RefreshTokenEntity;
import saba.project.global.security.auth.domain.repository.RefreshTokenRepository;
import saba.project.global.security.dto.TokenResponse;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider { // token 공급자


    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    // 토큰 생성
    public TokenResponse createToken(String accountId) {
        return TokenResponse
                .builder()
                .accessToken(createAccessToken(accountId))
                .refreshToken(createRefreshToken(accountId))
                .build();
    }

    public String createAccessToken(String accountId) {
        Claims claims = Jwts.claims().setSubject(accountId);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExp() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();

    }
    private String createRefreshToken(String accountId) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(accountId)
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExp() * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();

        refreshTokenRepository.save(
                RefreshTokenEntity.builder()
                        .accountId(accountId)
                        .refreshToken(refreshToken)
                        .expiration(jwtProperties.getRefreshExp())
                        .build());

        return refreshToken;
    }
    // 토큰 받을 때
    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // 파싱 진행
    private Claims getBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException();
        }
    }

    //만료일자 확인
    public void validateToken(String jwtToken) {
        Claims body = getBody(jwtToken);
        if (body.getExpiration().before(new Date())) {
            throw new RuntimeException();
        }
    }


}