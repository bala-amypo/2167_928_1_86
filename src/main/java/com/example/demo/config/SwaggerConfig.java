package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {

        Server productionServer = new Server();
        productionServer.setUrl("https://9181.408procr.amypo.ai");
        productionServer.setDescription("Production Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Crop & Fertilizer API")
                        .version("1.0"))
                .servers(List.of(productionServer));
    }
}
