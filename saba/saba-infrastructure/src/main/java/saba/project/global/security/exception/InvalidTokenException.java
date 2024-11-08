package saba.project.global.security.exception;

import saba.example.common.error.SabaException;
import saba.project.global.security.exception.error.SecurityErrorCode;

public class InvalidTokenException extends SabaException {
    private static final InvalidTokenException EXCEPTION = new InvalidTokenException();
    public InvalidTokenException() {
        super(SecurityErrorCode.CLAIM_FAILED);
    }
}
