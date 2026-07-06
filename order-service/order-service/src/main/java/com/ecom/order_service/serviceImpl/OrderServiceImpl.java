package com.ecom.order_service.serviceImpl;

import com.ecom.order_service.client.InventoryClient;
import com.ecom.order_service.dto.InventoryResponse;
import com.ecom.order_service.entities.Order;
import com.ecom.order_service.exception.ResourceNotFoundException;
import com.ecom.order_service.repository.OrderRepository;
import com.ecom.order_service.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public OrderServiceImpl(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    @Override
    public Order createOrders(Order order) {

        InventoryResponse response = inventoryClient.getInventory(order.getProductId());

        order.setOrderDate(LocalDateTime.now());

        if(response.getQuantity() >= order.getQuantity()){
            return orderRepository.save(order);
        } else {
            throw new ResourceNotFoundException("Out of Stock");
        }
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
