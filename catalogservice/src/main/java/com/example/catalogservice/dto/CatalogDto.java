package com.example.catalogservice.dto;

import com.example.catalogservice.domain.Catalog;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogDto {

    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;

    private String orderId;
    private String userId;

    @Builder
    public CatalogDto(String productId, String productName, Integer stock, Integer unitPrice, String orderId, String userId) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.orderId = orderId;
        this.userId = userId;
    }

    public CatalogDto(Catalog catalog) {
        this.productId = catalog.getProductId();
        this.productName = catalog.getProductName();
        this.stock = catalog.getStock();
        this.unitPrice = catalog.getUniPrice();
    }
}
