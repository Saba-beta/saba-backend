package saba.example.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saba.example.domain.auth.presentation.dto.mapper.EmailAuthMapper;
import saba.example.domain.auth.presentation.dto.request.EmailAuthRequestInfra;
import saba.example.domain.auth.usecase.EmailAuthUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class EmailAuthWebAdapter {
    private final EmailAuthUseCase emailAuthUseCase;
    private final EmailAuthMapper emailAuthMapper;

    @PostMapping("/email")
    public int emailAuthentication(EmailAuthRequestInfra mail){


        return emailAuthUseCase.execute(emailAuthMapper.toApp(mail));
    }
}
