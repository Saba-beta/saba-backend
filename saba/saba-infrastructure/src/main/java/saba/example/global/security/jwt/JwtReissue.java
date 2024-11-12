package saba.example.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saba.example.domain.auth.dto.response.TokenResponseApp;
import saba.example.domain.auth.model.Authority;
import saba.example.global.security.auth.AuthDetailsService;
import saba.example.domain.auth.exception.InvalidTokenException;
import saba.example.domain.auth.exception.NotRefreshTokenException;

@RequiredArgsConstructor
@Service
@Transactional
// TODO Security 부분 좀 마음에 안드는데 리펙토링 하자(특히 Reissue랑 TokenProvider 합치는 부분 고려)
public class JwtReissue {
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public TokenResponseApp reissue(String refreshToken, Authority authority) {

        if(!isRefreshToken(refreshToken)) {
            throw new NotRefreshTokenException();
        }

        String accountId = getId(refreshToken);

        return TokenResponseApp.builder()
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
