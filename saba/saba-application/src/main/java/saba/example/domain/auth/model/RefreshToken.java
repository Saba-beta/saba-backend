package saba.example.domain.auth.model;

import lombok.Builder;
import lombok.Getter;
import saba.example.common.annotation.Aggregate;
import saba.example.domain.auth.model.type.Authority;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class RefreshToken {
    private String userId;

    private String refreshToken;

    private Authority authority;

    private Long expiration;



    public RefreshToken updateExpiration(Long expiration) {
        this.expiration = expiration;
        return this;
    }
}
