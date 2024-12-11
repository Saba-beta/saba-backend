package saba.example.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import saba.example.global.security.jwt.JwtFilter;
import saba.example.global.security.jwt.JwtReissue;
import saba.example.global.security.jwt.JwtTokenProvider;

// TODO FilterConfig, SecurityConfig 구축하기
@Component
@RequiredArgsConstructor
public class FilterConfig implements SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtReissue jwtReissue;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void init(HttpSecurity http) throws Exception {
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new JwtFilter(jwtTokenProvider, jwtReissue), UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(new GlobalExceptionFilter(objectMapper, eventPublisher), JwtFilter.class);
    }
}

