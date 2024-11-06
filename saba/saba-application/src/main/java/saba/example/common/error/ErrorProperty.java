package saba.example.common.error;

public interface ErrorProperty {
    HttpStatus getHttpStatus();
    String getMessage();
}
