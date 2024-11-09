package saba.example.domain.user.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.user.exception.error.UserErrorCode;

public class PasswordInvalidException extends SabaException {
    public final static SabaException EXCEPTION = new PasswordInvalidException();
    private PasswordInvalidException() {
        super(UserErrorCode.USER_INVALID);
    }
}
