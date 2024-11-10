package saba.example.domain.auth.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import saba.example.common.error.ErrorProperty;
import saba.example.common.error.CustomHttpStatus;

@RequiredArgsConstructor
@Getter
@Component
public enum SecurityErrorCode implements ErrorProperty {
    CLAIM_FAILED(CustomHttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다."),
    NOT_REFRESH_TOKEN(CustomHttpStatus.UNAUTHORIZED, "토큰이 리프레시 토큰이 아닙니다."),
    EXPIRED_TOKEN(CustomHttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
    USER_ALREADY_EXIST(CustomHttpStatus.CONFLICT, "유저가 이미 존재합니다.");

    private final CustomHttpStatus httpStatus;
    private final String message;
}
