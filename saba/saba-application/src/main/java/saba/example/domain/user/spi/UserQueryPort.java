package saba.example.domain.user.spi;

import saba.example.domain.user.model.User;

public interface UserQueryPort {

    User save(User user);

    User getByAccountId(String accountId);
}
