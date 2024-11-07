package saba.project.global.security.auth.domain;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@RedisHash("refresh_token")
public class RefreshTokenEntity {
    @Id
    private String accountId;

    private String refreshToken;

    @TimeToLive
    private Long expiration;

    public RefreshTokenEntity updateExpiration(Long expiration) {
        this.expiration = expiration;
        return this;
    }

}
