package saba.project.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
// TODO 추가되는 Controller에 Swagger 기능 추가하기
public class SwaggerConfig {
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }
    private Info apiInfo(){
        return new Info()
                .title("Saba API")
                .description("User의 위치에 따라 다양한 관광명소를 소개 시켜주는 REST API")
                .version("1.0.0");
    }
}
