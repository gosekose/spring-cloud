package com.example.orderservice.service;

import com.example.orderservice.domain.Orders;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> getOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId).stream().map(OrderDto::new).collect(Collectors.toList());
    }

    public OrderDto getOrderByOrderId(String orderId) {
        Orders findOrders = orderRepository.findByOrderId(orderId);

        if (findOrders == null) {
            return null;
        }
        return new OrderDto(findOrders);
    }

    public void save(String userId, OrderDto orderDto) {
        orderRepository.save(new Orders(userId, orderDto));
    }

}
