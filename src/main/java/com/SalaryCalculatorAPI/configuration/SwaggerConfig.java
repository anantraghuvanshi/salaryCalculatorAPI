package com.SalaryCalculatorAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.SalaryCalculatorAPI.controller"))
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Salary Calculator API",
                "API for calculating salary based on tax regime",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Your Name", "www.yourwebsite.com", "your@email.com"),
                "API License",
                "www.yourwebsite.com",
                Collections.emptyList());
    }

}
