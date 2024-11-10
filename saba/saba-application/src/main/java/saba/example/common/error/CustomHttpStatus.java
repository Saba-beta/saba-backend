package saba.example.common.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum CustomHttpStatus {
    OK(200),
    CREATED(201),

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    CONFLICT(409),

    INTERNAL_SERVER_ERROR(500);

    private final int statusCode;

    CustomHttpStatus(int statusCode){
        this.statusCode = statusCode;
    }
}
