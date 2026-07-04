package com.ecom.order_service.service;

import com.ecom.order_service.entities.Order;

import java.util.List;

public interface OrderService {
    Order createOrders(Order order);

    List<Order> getAllOrders();

    Order getOrdersById(Long id);

    void deleteOrder(Long id);
}
