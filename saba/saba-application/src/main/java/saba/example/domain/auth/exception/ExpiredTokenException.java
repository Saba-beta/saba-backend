package saba.example.domain.auth.exception;

import saba.example.common.error.ErrorProperty;
import saba.example.common.error.SabaException;
import saba.example.domain.auth.exception.error.SecurityErrorCode;

public class ExpiredTokenException extends SabaException {
    public static final SabaException EXCEPTION = new ExpiredTokenException();
    public ExpiredTokenException() {
        super(SecurityErrorCode.EXPIRED_TOKEN);
    }
}
