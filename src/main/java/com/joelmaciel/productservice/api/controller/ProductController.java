package com.joelmaciel.productservice.api.controller;

import com.joelmaciel.productservice.domain.model.ProductRequest;
import com.joelmaciel.productservice.domain.model.ProductDTO;
import com.joelmaciel.productservice.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @GetMapping("/{productId}")
    public ProductDTO getByProductId(@PathVariable UUID productId) {
        return productService.findById(productId);
    }

    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/reduceQuantity/{productId}")
    public void reduceQuantity(@PathVariable UUID productId, @RequestParam Integer quantity) {
        productService.reduceQuantity(productId, quantity);
    }

}
