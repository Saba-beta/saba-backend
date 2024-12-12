package saba.example.domain.user.persistence;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.Adapter;
import saba.example.domain.user.exception.UserNotFoundException;
import saba.example.domain.user.model.User;
import saba.example.domain.user.persistence.mapper.UserMapper;
import saba.example.domain.user.persistence.repository.UserRepository;
import saba.example.domain.user.spi.UserPort;

@Adapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public User save(User user) {
        return userMapper.toDomain(
                userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public User getByAccountId(String accountId) {
        try{
            return userMapper.toDomain(userRepository.findByAccountId(accountId));
        }catch(Exception e){
            throw UserNotFoundException.EXCEPTION;

        }

    }
}
