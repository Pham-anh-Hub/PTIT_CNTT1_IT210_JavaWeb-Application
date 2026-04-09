package com.restaurant.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.restaurant")
public class AppConfig {
    // Cấu hình view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // Set tiền tố
        viewResolver.setPrefix("/WEB-INF/views/");
        // Set hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
