package saba.example.domain.auth.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.auth.exception.error.SecurityErrorCode;

public class UserAlreadyExistException extends SabaException {
    public static final SabaException EXCEPTION = new UserAlreadyExistException();

    public UserAlreadyExistException() {
        super(SecurityErrorCode.USER_ALREADY_EXIST);
    }
}
