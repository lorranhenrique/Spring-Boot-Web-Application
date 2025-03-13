package com.web.tornese.SpringWeb.servico.autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) new LoginInterceptor())
                .excludePathPatterns(
        "/login",
                    "/logar",
                    "/css/**",
                    "/js/**",
                    "/img/**",
                    "/fonts/**",
                    "/error",
                    "/vendor/**",
                    "/favicon.ico"
                );
    }
}

