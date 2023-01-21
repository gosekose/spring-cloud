package com.example.orderservice.domain;

import com.example.orderservice.dto.OrderDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id @GeneratedValue
    private Long id;

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String userId;
    private String orderId;

    private LocalDateTime createdAt;

    @Builder
    public Orders(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, String userId, String orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.orderId = orderId;
        this.createdAt = LocalDateTime.now();
    }

    public Orders(String userId, OrderDto orderDto) {
        this.productId = orderDto.getProductId();
        this.quantity = orderDto.getQuantity();
        this.unitPrice = orderDto.getUnitPrice();
        this.totalPrice = orderDto.getTotalPrice();
        this.userId = userId;
        this.orderId = orderDto.getOrderId();
    }
}
