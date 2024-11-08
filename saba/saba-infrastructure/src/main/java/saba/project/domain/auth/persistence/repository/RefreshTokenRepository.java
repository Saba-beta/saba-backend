package saba.project.domain.auth.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import saba.example.domain.auth.spi.RefreshTokenPort;
import saba.project.domain.auth.persistence.RefreshTokenEntity;

public interface RefreshTokenRepository extends RefreshTokenPort {
}
