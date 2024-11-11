package saba.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

// TODO 로깅 시스템 구축하기
@ConfigurationPropertiesScan
@SpringBootApplication
@EnableScheduling
public class SabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SabaApplication.class, args);
    }
}
