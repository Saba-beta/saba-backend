package saba.example.domain.auth.spi;

import saba.example.domain.auth.model.RefreshToken;

public interface RefreshTokenPort {
    void save(RefreshToken refreshToken);

    void delete(RefreshToken refreshToken);
}
