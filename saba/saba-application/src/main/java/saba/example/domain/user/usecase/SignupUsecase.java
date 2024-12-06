package saba.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.UseCase;
import saba.example.common.spi.SecurityPort;
import saba.example.domain.auth.dto.response.TokenResponse;
import saba.example.domain.auth.spi.JwtPort;
import saba.example.domain.user.dto.request.SignupRequest;
import saba.example.domain.user.model.User;
import saba.example.domain.user.spi.UserPort;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class SignupUsecase {
    private final JwtPort jwtPort;
    private final UserPort userPort;
    private final SecurityPort securityPort;

    public TokenResponse execute(SignupRequest request){
        securityPort.isUserExist(request.getAccountId());
        User user = User.builder()
                .id(UUID.randomUUID().toString()) // 유저 id는 UUID로 저장
                .accountId(request.getAccountId())
                .authority(request.getAuthority())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
        userPort.save(user);

        return jwtPort.createToken(user.getId(), user.getAuthority());
    }
}
