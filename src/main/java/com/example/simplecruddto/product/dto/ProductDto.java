package com.example.simplecruddto.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long person_id;
    //private ProductPersonDto person;
    private List<ProductCategoriesDto> categoriesList;
}
