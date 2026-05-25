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
                .csrf(csrf -> csrf.disable()) // تعطيل حماية CSRF لإضافة المنتجات بسلاسة
                .authorizeHttpRequests(auth -> auth
                        // السماح لـ Railway والزوار بالوصول للمسار الرئيسي وصفحة المنتجات لتجنب الـ Crash
                        .requestMatchers("/", "/index", "/products", "/css/**", "/js/**").permitAll()
                        // طلب تسجيل الدخول لبقية الروابط الحساسة
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .permitAll() // تفعيل شاشة تسجيل الدخول الافتراضية للجميع
                        .defaultSuccessUrl("/", true) // التوجيه للمسار الرئيسي بعد نجاح الدخول
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}