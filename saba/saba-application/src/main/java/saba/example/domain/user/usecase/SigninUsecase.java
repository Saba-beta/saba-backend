package saba.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.UseCase;
import saba.example.domain.auth.dto.response.TokenResponse;
import saba.example.domain.auth.spi.JwtPort;
import saba.example.domain.user.dto.request.SigninRequest;
import saba.example.domain.user.model.User;
import saba.example.domain.user.spi.UserPort;
import saba.example.domain.user.util.UserPasswordChecker;

@UseCase
@RequiredArgsConstructor
public class SigninUsecase {
    private final UserPort userPort;
    private final UserPasswordChecker userPasswordChecker;
    private final JwtPort jwtPort;

    public TokenResponse execute(SigninRequest request){
        User user = userPort.getByAccountId(request.getAccountId());
        userPasswordChecker.execute(request.getPassword(), user.getPassword());
        userPort.save(user);

        return jwtPort.createToken(user.getId(), user.getAuthority());
    }
}
