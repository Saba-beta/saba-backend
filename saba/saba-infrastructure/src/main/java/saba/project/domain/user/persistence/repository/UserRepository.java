package saba.project.domain.user.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import saba.project.domain.user.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<Long, UserEntity> {

}
