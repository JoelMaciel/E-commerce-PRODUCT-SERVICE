package com.joelmaciel.productservice.domain.model;

import com.joelmaciel.productservice.domain.entitty.Product;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank
    private String name;
    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    @NotNull
    @PositiveOrZero
    private Integer quantity;

    public static Product toEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
    }
}
