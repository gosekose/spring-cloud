package com.example.orderservice.dto;

import com.example.orderservice.domain.Orders;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String userId;
    private String orderId;

    @Builder
    public OrderDto(String productId, Integer quantity, Integer unitPrice, Integer totalPrice, String userId, String orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.orderId = orderId;
    }

    public OrderDto(Orders orders) {
        this.productId = orders.getProductId();
        this.quantity = orders.getQuantity();
        this.unitPrice = orders.getUnitPrice();
        this.totalPrice = orders.getTotalPrice();
        this.userId = orders.getUserId();
        this.orderId = orders.getOrderId();
    }




}
