package com.filxconnect.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Allow requests from all domains dynamically
        corsConfiguration.addAllowedOriginPattern("*");  // ✅ This is better for dynamic frontend URLs
        
        // Allow all HTTP methods
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Allow common headers
        corsConfiguration.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization"));
        
        // Allow credentials (important for authentication)
        corsConfiguration.setAllowCredentials(true);

        // Apply CORS settings globally
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }
}
