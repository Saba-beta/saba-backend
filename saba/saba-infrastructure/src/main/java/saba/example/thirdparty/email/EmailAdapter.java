package saba.example.thirdparty.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import saba.example.domain.auth.spi.EmailPort;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
// TODO MiemeMessage 오류 해결하기
public class EmailAdapter implements EmailPort {

    @Override
    public void makeRandomNumber() {

    }

    @Override
    public String sendMail(String email) {
        return null;
    }
}