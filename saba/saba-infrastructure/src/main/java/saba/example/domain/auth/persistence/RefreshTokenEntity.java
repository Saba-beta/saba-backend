package saba.example.domain.auth.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import saba.example.domain.auth.model.Authority;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@RedisHash("refresh_token")
public class RefreshTokenEntity {
    @Id
    private String userId;

    private String refreshToken;

    private Authority authority;

    @TimeToLive
    private Long expiration;



    public RefreshTokenEntity updateExpiration(Long expiration) {
        this.expiration = expiration;
        return this;
    }

}
