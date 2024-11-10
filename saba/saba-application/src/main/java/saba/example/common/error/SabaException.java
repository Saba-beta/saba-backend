package saba.example.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SabaException extends RuntimeException{
    private final ErrorProperty errorProperty;

    public SabaException(ErrorProperty errorProperty) {
        this.errorProperty = errorProperty;
    }
}
