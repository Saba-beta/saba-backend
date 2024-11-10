package saba.example.common.error;

public interface ErrorProperty {
    CustomHttpStatus getHttpStatus();
    String getMessage();
}
