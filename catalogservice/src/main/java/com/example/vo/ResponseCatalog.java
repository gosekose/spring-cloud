package com.example.vo;

import com.example.catalogservice.domain.Catalog;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;

    public ResponseCatalog(Catalog catalog) {
        this.productId = catalog.getProductId();
        this.productName = catalog.getProductName();
        this.stock = catalog.getStock();
        this.unitPrice = catalog.getUniPrice();
    }
}
