package com.example.orderservice.repository;

import com.example.orderservice.domain.Orders;
import com.example.orderservice.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByUserId(String userId);
    Orders findByOrderId(String orderId);
}
