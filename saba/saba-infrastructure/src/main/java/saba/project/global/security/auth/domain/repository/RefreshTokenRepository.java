package saba.project.global.security.auth.domain.repository;

import org.springframework.data.repository.CrudRepository;
import saba.project.global.security.auth.domain.RefreshTokenEntity;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, Long> {
}
