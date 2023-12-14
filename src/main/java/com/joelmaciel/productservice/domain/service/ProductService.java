package com.joelmaciel.productservice.domain.service;

import com.joelmaciel.productservice.domain.entitty.Product;
import com.joelmaciel.productservice.domain.model.ProductRequest;
import com.joelmaciel.productservice.domain.model.ProductDTO;

import java.util.UUID;

public interface ProductService {
    ProductDTO saveProduct(ProductRequest productRequest);

    ProductDTO findById(UUID productId);

    Product findProductId(UUID productId);

    void reduceQuantity(UUID productId, Integer quantity);
}
