package saba.example.domain.auth.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthRequest {
    private String email;
}
