package saba.example.domain.auth.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.auth.exception.error.SecurityErrorCode;

public class NotRefreshTokenException extends SabaException {
    private static final SabaException EXCEPTION = new NotRefreshTokenException();
    public NotRefreshTokenException() {
        super(SecurityErrorCode.NOT_REFRESH_TOKEN);
    }
}
