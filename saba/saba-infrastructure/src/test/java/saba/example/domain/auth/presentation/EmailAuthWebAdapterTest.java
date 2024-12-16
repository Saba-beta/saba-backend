package saba.example.domain.auth.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import saba.example.domain.auth.dto.request.EmailAuthRequest;

@SpringBootTest
class EmailAuthWebAdapterTest {
    @Autowired
    private EmailAuthUseCase emailAuthUseCase;

//    @Test
//    @DisplayName("이메일 유즈케이스 테스트")
//    void useCaseBasicTest() {
//        EmailAuthRequest request = EmailAuthRequest.builder()
//                .email("testBoy@test.example")
//                .build();
//        int number = 0;
//        number = emailAuthUseCase.execute(request);
//        assertNotEquals(number, 0);
//    }
}