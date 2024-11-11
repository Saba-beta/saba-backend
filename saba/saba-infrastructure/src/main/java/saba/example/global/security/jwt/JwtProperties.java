package saba.example.global.security.jwt;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
@Getter
public class JwtProperties {
    @Value("${jwt.secret_key}")
    private String secretKey;

    @Value("${jwt.access_exp}")
    private Long accessExp;

    @Value("${jwt.refresh_exp}")
    private Long refreshExp;

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    @PostConstruct
    private void encodeSecretKey() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }

}
