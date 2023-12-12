package com.joelmaciel.productservice.domain.repository;

import com.joelmaciel.productservice.domain.entitty.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
