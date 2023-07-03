package com.fire.fire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("logowanie_responsywne");
        registry.addViewController("/logowanie_responsywne").setViewName("logowanie_responsywne");
        registry.addViewController("/").setViewName("/logowanie_responsywne");
        registry.addViewController("/PROFIL_2").setViewName("PROFIL_2");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");
    }
}
