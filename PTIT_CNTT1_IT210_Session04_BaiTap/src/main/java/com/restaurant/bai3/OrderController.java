package com.restaurant.bai3;

import com.restaurant.bai1.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class OrderController {

    private final OrderService orderService;

    // Constructor Injection
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String page() {
        return "menu";
    }


    // lấy chi tiết đơn hàng với PathVariable
    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderDetail(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }


    @GetMapping("/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }
}
