package com.Byte.Buddy.QuizAppByMe.config;




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
                    registry.addMapping("/**") // Apply to all endpoints
                            .allowedOrigins("http://localhost:3000" ) // Allow frontend URL
                            .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow methods
                            .allowedHeaders("*"); // Allow all headers
                }
            };
        }
    }


