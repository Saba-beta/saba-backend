package saba.project.global.security.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum SecurityErrorCode implements ErrorProperty {
    CLAIM_FAILED(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다."),
    NOT_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 리프레시 토큰이 아닙니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
