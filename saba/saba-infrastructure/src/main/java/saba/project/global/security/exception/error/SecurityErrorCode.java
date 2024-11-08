package saba.project.global.security.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum SecurityErrorCode implements ErrorProperty {
    CLAIM_FAILED(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
