package com.joelmaciel.productservice.domain.service.impl;

import com.joelmaciel.productservice.domain.entitty.Product;
import com.joelmaciel.productservice.domain.exception.ProductInsufficientQuantityException;
import com.joelmaciel.productservice.domain.exception.ProductNotFoundException;
import com.joelmaciel.productservice.domain.model.ProductDTO;
import com.joelmaciel.productservice.domain.model.ProductRequest;
import com.joelmaciel.productservice.domain.repository.ProductRepository;
import com.joelmaciel.productservice.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDTO saveProduct(ProductRequest productRequest) {
        log.info("Adding Product...");
        Product product = ProductRequest.toEntity(productRequest);
        log.info("Product Created");
        return ProductDTO.toDTO(productRepository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(UUID productId) {
        Product product = findProductId(productId);
        log.info("Get the product for productId: {}", productId);
        return ProductDTO.toDTO(product);
    }

    @Override
    @Transactional
    public void reduceQuantity(UUID productId, Integer quantity) {
        log.info("Reduce Quantity {} for  UUID: {}", quantity, productId);
        Product product = findProductId(productId);

        if (product.getQuantity() < quantity) {
            throw new ProductInsufficientQuantityException(quantity);
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductId(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

}
