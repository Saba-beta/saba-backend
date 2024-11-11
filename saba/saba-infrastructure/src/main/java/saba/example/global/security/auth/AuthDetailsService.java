package saba.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import saba.example.domain.user.persistence.entity.UserEntity;
import saba.example.domain.user.persistence.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public AuthDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByAccountId(accountId);
        return new AuthDetails(user);
    }
}
