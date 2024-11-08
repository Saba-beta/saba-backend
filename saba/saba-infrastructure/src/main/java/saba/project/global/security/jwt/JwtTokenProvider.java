package saba.project.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import saba.example.domain.auth.dto.TokenResponse;
import saba.example.domain.auth.model.Authority;
import saba.example.domain.auth.model.RefreshToken;
import saba.project.domain.auth.persistence.repository.RefreshTokenRepository;
import java.time.LocalDateTime;
import java.util.Date;
// TODO Jwt예외 처리하기
@RequiredArgsConstructor
@Component
public class JwtTokenProvider { // token 공급자

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    // 토큰 생성
    public TokenResponse createToken(String accountId, Authority authority) {
        return TokenResponse
                .builder()
                .accessToken(createAccessToken(accountId, authority))
                .accessExpiresTime(LocalDateTime.now().plusSeconds(jwtProperties.getRefreshExp()))
                .refreshToken(createRefreshToken(accountId, authority))
                .refreshExpiresTime(LocalDateTime.now().plusSeconds(jwtProperties.getRefreshExp()))
                .build();
    }

    public String createAccessToken(String accountId, Authority authority) {
        Claims claims = Jwts.claims().setSubject(accountId);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExp() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .claim("authority",authority)
                .compact();

    }
    private String createRefreshToken(String userId, Authority authority) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(userId)
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExp() * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .claim("authority",authority)
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userId(userId)
                        .refreshToken(refreshToken)
                        .expiration(jwtProperties.getRefreshExp())
                        .authority(authority)
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