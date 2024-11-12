package saba.example.thirdparty.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import saba.example.common.annotation.Adapter;
import saba.example.domain.auth.exception.EmailSendFailedException;
import saba.example.domain.auth.spi.EmailPort;


// TODO 코드 리펙토링 고려하기(코드가 구림)
@Adapter
public class EmailAdapter implements EmailPort {


    public EmailAdapter(JavaMailSender javaMailSender, EmailProperties emailProperties) {
        this.javaMailSender = javaMailSender;
        this.emailProperties = emailProperties;
        this.senderEmail = emailProperties.getUsername();
    }

    private final JavaMailSender javaMailSender;
    private final EmailProperties emailProperties;
    private final String senderEmail;
    private static int number;

    public void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage createMail(String mail){
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            throw EmailSendFailedException.EXCEPTION;
        }
        return message;
    }

    public int sendMail(String mail){
        try {
            MimeMessage message = createMail(mail);
            javaMailSender.send(message);
            return number;
        } catch (RuntimeException e) {
            throw EmailSendFailedException.EXCEPTION;
        }

    }
}