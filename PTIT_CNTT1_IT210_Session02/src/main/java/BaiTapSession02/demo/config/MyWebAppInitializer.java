package BaiTapSession02.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // LỖI ở đây — Servlet Mapping bị đặt sai
    @Override
    protected String[] getServletMappings() {
//        return new String[] { "/api/*" };   // ← Chú ý

        // logic yêu cầu container chỉ chuyển các yêu cầu bắt đầu với path /api/ tới cho DispatcherServelet xử lý
        // ==> Container sẽ kiểm tra URL Request, do đó, khi url request là /welcome (tuyệt đối)
        // nó sẽ không tìm thấy url khớp trong /api/*
        // --> và vì không tìm thấy --> ném ra lỗi 404 - not found

        // sửa lại
        return new String[]{"/"};

    }

}
