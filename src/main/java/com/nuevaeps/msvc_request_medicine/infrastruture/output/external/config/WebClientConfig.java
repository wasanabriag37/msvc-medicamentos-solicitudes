package com.nuevaeps.msvc_request_medicine.infrastruture.output.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Value("${clients.users.uri}")
    private String apiUser;

    @Bean
    public WebClient webClientUser(WebClient.Builder builder) {
        return builder.baseUrl(apiUser).build();
    }

}
