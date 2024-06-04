package com.ecommerce.micrommerce.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Value("${openapi.dev.url}")
    private String devUrl;
    @Value("${openapi.prod.url}")
    private String prodUrl;
    @Bean
    public OpenAPI micrommerceOpenApi() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server Url - Dev environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server Url - Production environment");

        Contact contact = new Contact();
        contact.setEmail("it@vocaltech.fr");
        contact.setName("Vocaltech");
        contact.setUrl("https://www.vocaltech.fr");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Micrommerce API")
                .version("1.0")
                .contact(contact)
                .description("API endpoints for Micrommerce")
                .termsOfService("")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
