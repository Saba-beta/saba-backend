package saba.example.domain.auth.presentation.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponseInfra {
    @ApiModelProperty(example = "accessToken")
    private final String accessToken;
    @ApiModelProperty(example = "accessToken 남은 시간")
    private final LocalDateTime accessExpiresTime;
    @ApiModelProperty(example = "refreshToken")
    private final String refreshToken;
    @ApiModelProperty(example = "refreshToken 남은 시간")
    private final LocalDateTime refreshExpiresTime;
}
