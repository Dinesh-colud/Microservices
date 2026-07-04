package com.ecom.order_service.serviceImpl;

import com.ecom.order_service.entities.Order;
import com.ecom.order_service.exception.ResourceNotFoundException;
import com.ecom.order_service.repository.OrderRepository;
import com.ecom.order_service.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrders(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrdersById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: "+id));
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: "+id));

        orderRepository.delete(order);
    }
}
