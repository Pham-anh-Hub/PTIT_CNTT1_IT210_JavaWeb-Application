package org.example.ptit_cntt1_it210_baithuchanh_session02.configs;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Khởi tạo
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    // Liệt kê <->  Các lớp cấu hình
    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // Cấu hình đường dẫn request đi qua (urls)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
