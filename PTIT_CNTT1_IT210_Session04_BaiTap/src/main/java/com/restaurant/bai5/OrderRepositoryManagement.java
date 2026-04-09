package com.restaurant.bai5;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryManagement {

    public String findById(Long id) {
        return "Thông tin đơn hàng: " + id; // do không có lớp tạo - nên hiển thị id target order thôi
    }

    public String createOrder() {
        return "Đã tạo đơn hàng mới";
    }

    public String deleteById(String id) {
        return "Đã hủy đơn hàng: " + id;
    }
}