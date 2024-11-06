package saba.example.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SabaException extends RuntimeException{
    private final ErrorProperty errorProperty;
}
