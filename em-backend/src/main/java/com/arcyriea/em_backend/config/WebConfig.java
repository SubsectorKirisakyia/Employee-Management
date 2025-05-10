
package com.arcyriea.em_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
        .allowedOrigins("http://localhost:8080/", "http://localhost:3000/")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*") //Have to put it this way since I don't know the exact headers to use for this yet.
        .allowCredentials(true);
	}

}
