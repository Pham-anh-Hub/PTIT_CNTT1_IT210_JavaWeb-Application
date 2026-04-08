package org.example.ptit_cntt1_it210_baithuchanh_session02.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Đánh dấu là lớp cấu hình
@Configuration

// Mở chế độ Web MVC
@EnableWebMvc

// Chế độ quét bean để khởi tạo, quets tất cả từ package tổng (container) - sẽ là các file chứa Bean, Component
@ComponentScan(basePackages = "org.example.ptit_cntt1_it210_baithuchanh_session02")

public class AppConfig {

    // Cấu hình View
    // Khởi tạo thông qua InternalResourceResolver - lớp con của class AbstractAnnotation....
    // Mặc định Spring sẽ đọc Bean này --> sẽ biết được, có những view nào, nên trả về những view nào
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // set tiền tố
        viewResolver.setPrefix("/WEB-INF/views/");
        // set hậu tố
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
