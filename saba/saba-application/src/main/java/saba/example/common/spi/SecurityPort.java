package saba.example.common.spi;

import saba.example.domain.user.model.User;

public interface SecurityPort {
    User getCurrentUser();
    String encodePassword(String password);
    boolean isPasswordMatch(String rawPassword, String encodedPassword);
}
