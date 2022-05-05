package com.example.simplecruddto.product.repository;

import com.example.simplecruddto.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
