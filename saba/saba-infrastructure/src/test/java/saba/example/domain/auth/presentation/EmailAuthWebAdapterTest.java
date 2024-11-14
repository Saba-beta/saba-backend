package saba.example.domain.auth.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import saba.example.domain.auth.dto.request.EmailAuthRequest;
import saba.example.domain.auth.usecase.EmailAuthUseCase;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailAuthWebAdapterTest {
    @Autowired
    private EmailAuthUseCase emailAuthUseCase;

    @Test
    @DisplayName("이메일 유즈케이스 테스트")
    void useCaseBasicTest() {
        EmailAuthRequest request = EmailAuthRequest.builder()
                .email("testBoy@test.example")
                .build();
        int number = 0;
        number = emailAuthUseCase.execute(request);
        assertNotEquals(number, 0);
    }
}