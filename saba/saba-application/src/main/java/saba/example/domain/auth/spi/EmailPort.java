package saba.example.domain.auth.spi;

public interface EmailPort {
    void makeRandomNumber();

    String sendMail(String email);
}
