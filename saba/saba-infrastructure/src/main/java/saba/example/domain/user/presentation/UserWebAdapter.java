package saba.example.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saba.example.domain.auth.dto.response.TokenResponse;
import saba.example.domain.user.dto.request.SigninRequest;
import saba.example.domain.user.dto.request.SignupRequest;
import saba.example.domain.user.usecase.SigninUsecase;
import saba.example.domain.user.usecase.SignupUsecase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserWebAdapter {
    private final SigninUsecase signinUsecase;
    private final SignupUsecase signupUsecase;

    @PostMapping("/signup")
    public TokenResponse signup(SignupRequest request){
        return signupUsecase.execute(request);
    }

    @PostMapping("/signin")
    public TokenResponse signin(SigninRequest request){
        return signinUsecase.execute(request);
    }
}
