package saba.example.domain.auth.spi;

import jakarta.mail.internet.MimeMessage;

public interface EmailPort {
    void createNumber();

    MimeMessage createMail(String mail);

    int sendMail(String mail);

}
