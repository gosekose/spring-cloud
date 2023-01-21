package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{userId}/orders")
    public ResponseEntity createOrder(@PathVariable("userId") String userId, @RequestBody OrderDto orderDto) {
        orderService.save(userId, orderDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity getOrders(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("{orderId}")
    public ResponseEntity getOrder(@PathVariable("orderId") String orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByOrderId(orderId));
    }


}
