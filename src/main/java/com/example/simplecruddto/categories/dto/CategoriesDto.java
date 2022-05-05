package com.example.simplecruddto.categories.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriesDto {
    private Long id;
    private String name;
    private Long product_id;
}
