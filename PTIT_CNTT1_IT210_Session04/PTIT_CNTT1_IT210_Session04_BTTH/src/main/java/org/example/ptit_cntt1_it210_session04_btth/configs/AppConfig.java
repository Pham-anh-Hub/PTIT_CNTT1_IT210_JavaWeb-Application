package org.example.ptit_cntt1_it210_session04_btth.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.ptit_cntt1_it210_session04_btth")
public class AppConfig {

    // Cấu hình view
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // set tien to
        viewResolver.setPrefix("/WEB-INF/views/");

        // set hau to
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
