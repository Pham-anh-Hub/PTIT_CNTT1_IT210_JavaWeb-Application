package BaiTapSession02.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.demo.service")  // ← Chú ý
    // basePackage đang trỏ đến package cụ thể - service,
    // khiến componentScan sẽ chỉ thực hiện truy và quét đến các file có trong service dẫn đến việc quét và tìm kiếm bị bỏ sót
    // --> điều này sẽ gây ra rất nhiều rủi ro, chẳng hạn Yêu cầu được gửi đến sau khi kiểm tra và tìm kiếm,
    // sẽ không thể tìm ra và trả về theo yêu cầu đầu vào

// Sửa lại bằng
@ComponentScan(basePackages = "BaiTapSession02.demo")

public class WebConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
