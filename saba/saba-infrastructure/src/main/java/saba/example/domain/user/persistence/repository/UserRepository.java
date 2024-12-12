package saba.example.domain.user.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import saba.example.domain.user.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByAccountId(String accountId);
    void deleteByAccountId(String accountId);
}
