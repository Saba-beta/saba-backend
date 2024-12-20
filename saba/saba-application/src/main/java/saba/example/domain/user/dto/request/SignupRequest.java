package saba.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saba.example.domain.auth.model.type.Authority;

@Getter
@AllArgsConstructor
public class SignupRequest {
    @NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 5, max = 30, message = "account_id는 5글자 이상, 30글자 이하여야 합니다.")
    private String accountId;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
            "<=>?@＼^_`{|}~]{8,60}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되고, 8~60자를 지켜야합니다.")
    private String password;

    @NotBlank(message = "email은 공백, 띄어쓰기를 허용하지 않습니다.")
    private String email;

    @NotNull(message = "authority는 Null상태를 허용하지 않습니다.")
    private Authority authority;
}
