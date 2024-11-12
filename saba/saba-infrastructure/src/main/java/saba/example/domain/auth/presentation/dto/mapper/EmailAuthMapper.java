package saba.example.domain.auth.presentation.dto.mapper;

import org.springframework.stereotype.Component;
import saba.example.domain.auth.dto.request.EmailAuthRequestApp;
import saba.example.domain.auth.presentation.dto.request.EmailAuthRequestInfra;

@Component
public class EmailAuthMapper {
    public EmailAuthRequestApp toApp(EmailAuthRequestInfra requestInfra){
        return EmailAuthRequestApp.builder()
                .email(requestInfra.getEmail())
                .build();
    }
    public EmailAuthRequestInfra toInfra(EmailAuthRequestApp requestInfra){
        return EmailAuthRequestInfra.builder()
                .email(requestInfra.getEmail())
                .build();
    }
}
