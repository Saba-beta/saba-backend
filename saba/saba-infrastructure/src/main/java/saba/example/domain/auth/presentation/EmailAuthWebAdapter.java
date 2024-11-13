package saba.example.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saba.example.domain.auth.dto.request.EmailAuthRequest;
import saba.example.domain.auth.usecase.EmailAuthUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class EmailAuthWebAdapter {
    private final EmailAuthUseCase emailAuthUseCase;

    @PostMapping("/email")
    public int emailAuthentication(EmailAuthRequest mail){
        return emailAuthUseCase.execute(mail);
    }
}
