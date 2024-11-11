package saba.example.thirdparty.email;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class EmailProperties {
    @Value("${cloud.mail.username}")
    private String username;
    @Value("${cloud.mail.password}")
    private String password;
}
