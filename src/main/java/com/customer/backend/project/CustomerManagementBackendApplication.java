package com.customer.backend.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class CustomerManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementBackendApplication.class, args);
    }

    @Bean
    public Docket swaggerConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.customer"))
                .build()
                .apiInfo(getApiInfo());
    }

    public ApiInfo getApiInfo(){
        return new ApiInfo("Cusotmer Management tool", "API DOCUMENTION OF CUSTOMER MANAGMENT",
                "V1", "PRIVATE",
                new Contact("Pravin Desai", "sigmadevs.com", "pravindesai100@gmail.com"),
                "API LICENCE", "LICENCE URL NOT FOUND",
                new ArrayList<>());
    }

}
