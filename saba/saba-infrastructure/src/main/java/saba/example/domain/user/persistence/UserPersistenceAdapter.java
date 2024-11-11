package saba.example.domain.user.persistence;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.Adapter;
import saba.example.domain.user.model.User;
import saba.example.domain.user.persistence.mapper.UserMapper;
import saba.example.domain.user.persistence.repository.UserRepository;
import saba.example.domain.user.spi.UserRegisterPort;

@Adapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRegisterPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User save(User user) {
        return userMapper.toDomain(
                userRepository.save(userMapper.toEntity(user)));
    }
}
