package saba.example.domain.user.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.user.exception.error.UserErrorCode;

public class PasswordInvalidException extends SabaException {
    private final static SabaException EXCEPTION = new PasswordInvalidException();
    public PasswordInvalidException() {
        super(UserErrorCode.USER_INVALID);
    }
}
