package saba.example.thirdparty.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import saba.example.common.annotation.Adapter;
import saba.example.domain.auth.exception.EmailSendFailedException;
import saba.example.domain.auth.spi.EmailAuthPort;


@Adapter
@RequiredArgsConstructor
public class EmailAuthAdapter implements EmailAuthPort {
    private final JavaMailSender javaMailSender;
    private final EmailAuthProperties emailAuthProperties;

    public int sendMail(String mail){
        int number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(emailAuthProperties.getUsername());
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");

            javaMailSender.send(message); // 이메일 발송
            return number;
        } catch (MessagingException e) {
            throw EmailSendFailedException.EXCEPTION;
        }

    }
}