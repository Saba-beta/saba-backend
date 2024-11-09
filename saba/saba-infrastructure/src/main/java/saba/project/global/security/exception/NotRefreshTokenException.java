package saba.project.global.security.exception;

import ch.qos.logback.core.spi.ErrorCodes;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.SabaException;
import saba.project.global.security.exception.error.SecurityErrorCode;

public class NotRefreshTokenException extends SabaException {
    private static final SabaException EXCEPTION = new NotRefreshTokenException();
    public NotRefreshTokenException() {
        super(SecurityErrorCode.NOT_REFRESH_TOKEN);
    }
}
