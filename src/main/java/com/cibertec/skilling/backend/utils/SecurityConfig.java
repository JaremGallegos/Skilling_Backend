package com.cibertec.skilling.backend.utils;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.DELETE, 
                "/api/libros/**",
                "/api/simulaciones/**",
                "/api/profesores/**",
                "/api/estudiantes/**").permitAll()
                .requestMatchers(HttpMethod.PUT, 
                "/api/libros/**",
                "/api/simulaciones/**",
                "/api/auth/login/**",
                "/api/profesores/**",
                "/api/estudiantes/**").permitAll()
                .requestMatchers(HttpMethod.POST, 
                "/api/libros/**",
                "/api/simulaciones/**",
                "/api/auth/login/**",
                "/api/profesores/**",
                "/api/estudiantes/**").permitAll()
                .requestMatchers(HttpMethod.GET, 
                "/api/libros/**",
                "/api/simulaciones/**",
                "/api/auth/login/**",
                "/api/profesores/**",
                "/api/estudiantes/**").permitAll()
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/swagger-ui/**",
                    "/api/auth/login",
                    "/v3/api-docs/**",
                    "/register",
                    "/api/roles",
                    "/api/eventos",
                    "/api/libros",
                    "/api/administradores",
                    "/api/anuncios",
                    "/api/asistencias",
                    "/api/clases",
                    "/api/simulaciones",
                    "/api/estudiantes",
                    "/api/profesores",
                    "/api/eventos/enviar",
                    "/api/libros/cargar",
                    "/api/usuarios",
                    "/**/*.js",
                    "/**/*.ts",
                    "/**/*.css",
                    "/**/*.ico",
                    "/assets/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("logout", "GET"))
                .logoutSuccessUrl("/login")
                .permitAll()
            );
            //.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name(),
            HttpMethod.OPTIONS.name()
        ));

        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
