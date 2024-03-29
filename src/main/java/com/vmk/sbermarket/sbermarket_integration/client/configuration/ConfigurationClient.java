package com.vmk.sbermarket.sbermarket_integration.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class ConfigurationClient {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
