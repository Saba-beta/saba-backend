package saba.example.domain.auth.presentation.dto.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthRequestInfra {
    @Email
    @NotEmpty
    @ApiModelProperty(example = "이메일")
    private String email;
}
