package saba.example.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import saba.example.common.annotation.Adapter;
import saba.example.common.spi.SecurityPort;
import saba.example.domain.auth.exception.UserAlreadyExistException;
import saba.example.domain.user.model.User;
import saba.example.domain.user.persistence.entity.UserEntity;
import saba.example.domain.user.persistence.mapper.UserMapper;
import saba.example.domain.user.persistence.repository.UserRepository;

@Adapter
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity entity = userRepository.findByAccountId(accountId);

        return userMapper.toDomain(entity);
    }

    @Override
    public String encodePassword(String password) {
        return null;
    }

    @Override
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public void isUserExist(String accountId) {
        if(userRepository.findByAccountId(accountId) != null){
            throw UserAlreadyExistException.EXCEPTION;
        }
    }
}
