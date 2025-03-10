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
        
        // Allowed Origins (Update with your frontend URL)
        corsConfiguration.setAllowedOrigins(List.of("https://frontend-deploy-fil-userfilconnect-83uu88rdp.vercel.app"));
        
        // Allowed Methods
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Allowed Headers
        corsConfiguration.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization"));
        
        // Allow Credentials (Important for authentication)
        corsConfiguration.setAllowCredentials(true);
        
        // Apply CORS settings to all routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        
        return new CorsFilter(source);
    }
}
