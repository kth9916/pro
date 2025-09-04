package com.asan.pro.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 보호 기능 비활성화 (Stateless API 서버이므로)
            .csrf(csrf -> csrf.disable())
            // 세션을 사용하지 않는 Stateless 설정
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // 모든 요청에 대해 인증을 요구하도록 설정
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated()
            )
            // OAuth2 리소스 서버 설정을 활성화하고, JWT 토큰 검증을 사용하도록 설정
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}));

        return http.build();
    }
}
