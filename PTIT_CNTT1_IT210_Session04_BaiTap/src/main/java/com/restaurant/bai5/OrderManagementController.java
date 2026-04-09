package com.restaurant.bai5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/orders")
public class OrderManagementController {

    private final OrderManagemntService orderService;

    @Autowired
    public OrderManagementController(OrderManagemntService orderService) {
        this.orderService = orderService;
    }

    // xem đơn hàng
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // tạo đơn hàng
    @PostMapping
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }

    // Hủy đơn hàng
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }


}