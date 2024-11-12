package saba.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import saba.example.common.annotation.UseCase;
import saba.example.domain.auth.dto.request.EmailAuthRequest;
import saba.example.domain.auth.spi.EmailAuthPort;

@UseCase
@RequiredArgsConstructor
public class EmailAuthUseCase {
    private final EmailAuthPort emailAuthPort;

    public int execute(EmailAuthRequest mail){
        return emailAuthPort.sendMail(mail.getEmail());
    }
}
