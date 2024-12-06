package saba.example.domain.auth.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import saba.example.domain.auth.persistence.entity.RefreshTokenEntity;
import saba.example.domain.auth.spi.RefreshTokenPort;


public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String>, RefreshTokenPort {
}
