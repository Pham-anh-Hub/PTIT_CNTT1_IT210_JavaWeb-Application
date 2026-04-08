package BaiTapSession02.demo.controller.bai3;


import BaiTapSession02.demo.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    // Truy Application Scope qua ServeletContext
    private ServletContext application;

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model){
        // kiểm tra xem có thông tin nhân viên chưa
        String staffName = (String) session.getAttribute("staffName");
        if(staffName == null){
            return "redirect:/login";
        }

        // taọ danh sách đơn hàng giả
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORD001", "Laptop Dell XPS", 25000000.0, new Date()));
        orders.add(new Order("ORD002", "Chuột Logitech G502", 1200000.0, new Date()));
        orders.add(new Order("ORD003", "Bàn phím cơ ", 1850000.0, new Date()));
        orders.add(new Order("OR004", "Laptop ASUS ", 28000000.0, new Date()));

        // Đẩy danh sách vào scope để trang JSP hiển thị.
        //sử dụng modle để dữ liệu chỉ tồn tại trong request này
        model.addAttribute("orderList", orders);

        // Xử lý & cập nhật bộ đếm toàn cục
        synchronized (application) {
            Integer totalViewCount = (Integer) application.getAttribute("totalViewCount");
            if (totalViewCount == null) {
                totalViewCount = 0;
            }
            totalViewCount++;
            application.setAttribute("totalViewCount", totalViewCount);
        }
        return "bai3/orders";
    }


}
