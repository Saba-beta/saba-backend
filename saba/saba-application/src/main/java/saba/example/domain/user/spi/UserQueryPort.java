package saba.example.domain.user.spi;

import saba.example.domain.user.model.User;

public interface UserQueryPort {
    User getByAccountId(String accountId);

}
