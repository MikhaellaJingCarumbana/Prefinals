package com.example.Prefinals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editOrder(@PathVariable("id") int orderId, @RequestBody Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        existingOrder.setCustomerId(updatedOrder.getCustomerId());
        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setProductId(updatedOrder.getProductId());
        existingOrder.setAmount(updatedOrder.getAmount());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        orderRepository.save(existingOrder);
    }
}
