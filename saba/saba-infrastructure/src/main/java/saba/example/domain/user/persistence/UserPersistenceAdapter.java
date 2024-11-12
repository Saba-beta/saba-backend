package saba.example.domain.user.persistence;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.Adapter;
import saba.example.domain.user.exception.UserNotFoundException;
import saba.example.domain.user.model.User;
import saba.example.domain.user.persistence.mapper.UserMapper;
import saba.example.domain.user.persistence.repository.UserRepository;
import saba.example.domain.user.spi.UserQueryPort;

@Adapter
@RequiredArgsConstructor
public class userPersistenceAdapter implements UserQueryPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User save(User user) {
        return userMapper.toDomain(
                userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public User getByAccountId(String accountId) {
        User user = userMapper.toDomain(userRepository.findByAccountId(accountId));
        if (user == null){
            throw UserNotFoundException.EXCEPTION;
        }
        return user;
    }
}
