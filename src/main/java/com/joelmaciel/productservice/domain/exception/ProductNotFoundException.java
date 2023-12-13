package com.joelmaciel.productservice.domain.exception;

import java.util.UUID;

public class ProductNotFoundException extends EntityNotExistException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(UUID productId) {
        this(String.format("Product with given uuid not found %s", productId));
    }
}
