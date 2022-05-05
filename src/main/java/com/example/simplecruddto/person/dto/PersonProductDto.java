package com.example.simplecruddto.person.dto;

import com.example.simplecruddto.categories.entity.Categories;
import com.example.simplecruddto.product.dto.ProductCategoriesDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonProductDto {

    private Long id;
    private String name;
    private List<ProductCategoriesDto> categoriesList;
}
