package com.naluri.circle_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // semua endpoint
                        .allowedOrigins("*") // izinkan semua origin
                        .allowedMethods("GET", "POST", "PUT") // metode yang diizinkan
                        .allowedHeaders("*"); // header yang diizinkan
            }
        };
    }
}
