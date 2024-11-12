package saba.example.domain.user.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import saba.example.common.spi.SecurityPort;
import saba.example.domain.user.exception.PasswordInvalidException;

@Component
@RequiredArgsConstructor
public class UserPasswordChecker {
    private final SecurityPort securityPort;
    public void execute(String rawPassword, String encodedPassword){
        if (!securityPort.isPasswordMatch(rawPassword, encodedPassword)) {
            throw PasswordInvalidException.EXCEPTION;
        }
    }
}
