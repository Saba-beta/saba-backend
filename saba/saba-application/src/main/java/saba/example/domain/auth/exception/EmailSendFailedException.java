package saba.example.domain.auth.exception;

import saba.example.common.error.SabaException;
import saba.example.domain.auth.exception.error.SecurityErrorCode;

public class EmailSendFailedException extends SabaException {
    public static final SabaException EXCEPTION = new EmailSendFailedException();

    private EmailSendFailedException() {
        super(SecurityErrorCode.EMAIL_SEND_FAILED);
    }
}
