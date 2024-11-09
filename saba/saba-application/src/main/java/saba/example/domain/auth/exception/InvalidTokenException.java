package saba.example.domain.auth.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.auth.exception.error.SecurityErrorCode;

public class InvalidTokenException extends SabaException {
    public static final SabaException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException() {
        super(SecurityErrorCode.CLAIM_FAILED);
    }
}
