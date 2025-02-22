//package com.Byte.Buddy.QuizAppByMe.config;
//
//import org.apache.coyote.http11.AbstractHttp11Protocol;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.HttpSecurityDsl;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for API requests
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/signup", "/api/login").permitAll() // Public endpoints
//                        .anyRequest().authenticated() // Protect all other routes
//                )
//                .formLogin(withDefaults()); // Use Form-Based Authentication instead of httpBasic()
//
//        return http.build();
//    }
//
//
//
//
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//}
//
//
//
//
//
