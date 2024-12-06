package com.templates.global.config;

import static com.templates.global.config.SecurityPathConstants.AUTH_PATHS;
import static com.templates.global.config.SecurityPathConstants.SWAGGER_PATHS;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(requests ->
                requests.requestMatchers(HttpMethod.POST, AUTH_PATHS).permitAll()
                    .requestMatchers(SWAGGER_PATHS).permitAll()
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginProcessingUrl("/api/v1/login")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .successHandler((request, response, authentication) -> {
                    response.setStatus(200);
                })
                .failureHandler((request, response, exception) -> {
                    response.setStatus(401);
                })
            )
            .logout(logout -> logout
                .logoutUrl("/api/v1/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(200);
                })
            )
            .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}