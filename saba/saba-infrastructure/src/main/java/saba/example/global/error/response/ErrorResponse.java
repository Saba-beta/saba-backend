package saba.example.global.error.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import saba.example.common.error.ErrorProperty;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final Integer status;
    private final String message;

    public static ErrorResponse of(ErrorProperty errorProperty) {
        return new ErrorResponse(errorProperty.getHttpStatus().getStatusCode(), errorProperty.getMessage());
    }
}
