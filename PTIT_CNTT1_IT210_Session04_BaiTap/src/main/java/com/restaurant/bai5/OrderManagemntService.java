package com.restaurant.bai5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagemntService {

    private final OrderRepositoryManagement orderRepository;

    @Autowired
    public OrderManagemntService(OrderRepositoryManagement orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public String createOrder() {
        return orderRepository.createOrder();
    }

    public String deleteOrder(String id) {
        return orderRepository.deleteById(id);
    }
}
