package saba.project.global.security.exception;

import saba.example.common.error.SabaException;
import saba.project.global.security.exception.error.SecurityErrorCode;

public class InvalidTokenException extends SabaException {
    public static final SabaException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException() {
        super(SecurityErrorCode.CLAIM_FAILED);
    }
}
