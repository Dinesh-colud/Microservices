package com.ecom.order_service.controller;

import com.ecom.order_service.entities.Order;
import com.ecom.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order order1 = orderService.createOrders(order);

        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order = orderService.getOrdersById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }

}
