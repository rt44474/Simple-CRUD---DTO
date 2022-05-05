package com.example.simplecruddto.product.service;

import com.example.simplecruddto.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    ProductDto update(ProductDto productDto);
    ProductDto save(ProductDto productDto);
    void delete (Long id);
}
