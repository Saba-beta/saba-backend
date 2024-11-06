package saba.example.domain.user.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.user.exception.error.UserErrorCode;

public class UserNotFoundException extends SabaException {
    public static final SabaException EXCEPTION = new UserNotFoundException();
    public UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}
