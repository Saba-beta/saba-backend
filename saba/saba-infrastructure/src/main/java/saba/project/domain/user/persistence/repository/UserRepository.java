package saba.project.domain.user.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import saba.project.domain.user.persistence.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByAccountId(String accountId);
}
