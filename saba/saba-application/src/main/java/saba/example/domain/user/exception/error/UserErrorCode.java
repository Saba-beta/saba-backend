package saba.example.domain.user.exception.error;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.CustomHttpStatus;

@RequiredArgsConstructor
public enum UserErrorCode implements ErrorProperty{
    USER_NOT_FOUND(CustomHttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    USER_INVALID(CustomHttpStatus.UNAUTHORIZED, "비밀번호가 유효하지 않습니다.");

    private final CustomHttpStatus httpStatus;
    private final String message;

    @Override
    public CustomHttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
