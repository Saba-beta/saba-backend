package saba.example.domain.user.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.HttpStatus;

@RequiredArgsConstructor
public enum UserErrorCode implements ErrorProperty{
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저 없음");
    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
