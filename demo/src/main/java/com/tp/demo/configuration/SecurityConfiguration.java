package com.tp.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // تعطيل حماية CSRF لتتمكني من إضافة منتجات بسهولة
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // طلب تسجيل الدخول لكل الروابط
                )
                .httpBasic(Customizer.withDefaults()) // استخدام الحماية الأساسية
                .formLogin(Customizer.withDefaults()); // تفعيل شاشة تسجيل الدخول

        return http.build();
    }
}