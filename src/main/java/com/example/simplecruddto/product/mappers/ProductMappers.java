package com.example.simplecruddto.product.mappers;

import com.example.simplecruddto.product.dto.ProductDto;
import com.example.simplecruddto.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMappers {
    ProductDto toDto(Product product);
    Product fromDto(ProductDto productDto);
}
