package saba.example.domain.user.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.HttpStatus;

@RequiredArgsConstructor
public enum UserErrorCode implements ErrorProperty{
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    USER_INVALID(HttpStatus.UNAUTHORIZED, "비밀번호가 유효하지 않습니다.");
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
