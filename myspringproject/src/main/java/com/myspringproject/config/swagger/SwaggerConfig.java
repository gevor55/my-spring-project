package com.myspringproject.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("springproject@gmail.com");
        contact.setName("Spring");
        contact.setUrl("https://www.myspringproject.com");

        Info info = new Info()
                .title("My Spring Project API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints for my Spring project.")
                .termsOfService("https://www.myspringproject.com")
                .license(new License().name("MIT License").url("https://myspringproject.com/licenses"));

        return new OpenAPI().info(info).servers(null);
    }
}