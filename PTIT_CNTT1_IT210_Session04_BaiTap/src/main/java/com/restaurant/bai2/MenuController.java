package com.restaurant.bai2;


import com.restaurant.bai1.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//  Hàm cũ được viết là public String getMenu(@RequestParam("category") String category
//  Tuy nhiên, khi truy cập thẳng vào /bai2/menu mà "quên" không truyền loại món ăn (không có ?category=...),
//  hệ thống lập tức báo lỗi sập mạng

// Vấn đề: tham số truyền vào từ đường dẫn là @RequestParam("category") String category
// mà không có defaul value (lỗi chính dẫn đến rủi ro sập mạng khi không truyền tham số trên đường dẫn)


// Sửa lại
@Controller
@RequestMapping("/bai2")
public class MenuController {

    private final OrderService orderService;

    // Constructor Injection
    @Autowired
    public MenuController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public String menuPage() {
        return "menu";
    }


    //  lỗi thiếu param
    @GetMapping("/menu")
    @ResponseBody
    public String getMenu(
//            @RequestParam(value = "category") String category) { --> Lỗi request invalid
        @RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Menu loai: " + category; // tự tạo view do có @ResponseBody
    }

    // giống bài 1

    @GetMapping("/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}