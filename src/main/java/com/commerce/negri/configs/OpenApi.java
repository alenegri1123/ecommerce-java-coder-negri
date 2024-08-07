package com.commerce.negri.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce Java Negri",
                version = "1.0",
                description = "CRUD of ECommerce Negri"
        )
)

public class OpenApi {
}
