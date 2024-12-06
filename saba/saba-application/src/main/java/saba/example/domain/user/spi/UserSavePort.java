package saba.example.domain.user.spi;

import saba.example.domain.user.model.User;

public interface UserSavePort {
    User save(User user);

}
