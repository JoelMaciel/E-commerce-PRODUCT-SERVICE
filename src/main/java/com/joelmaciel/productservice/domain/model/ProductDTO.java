package com.joelmaciel.productservice.domain.model;

import com.joelmaciel.productservice.domain.entitty.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
