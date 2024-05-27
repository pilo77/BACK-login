package com.example.loginback.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info().title("Api REST con MySQL y Spring-booot ").version("1.0 SNAPSHOT")
                .contact(new Contact().name("Carlos Villamil").url("https://github.com/pilo77").email("cavillamil-2022a@corhuila.edu.co"))
                .description("Api encargada para registrar categoria y en ella recordatorios para las personas en una base de datos.")
        );
    }
}