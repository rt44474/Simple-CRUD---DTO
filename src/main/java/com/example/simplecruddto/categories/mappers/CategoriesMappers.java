package com.example.simplecruddto.categories.mappers;

import com.example.simplecruddto.categories.dto.CategoriesDto;
import com.example.simplecruddto.categories.entity.Categories;
import org.mapstruct.Mapper;

@Mapper
public interface CategoriesMappers {
    CategoriesDto toDto(Categories categories);
    Categories fromDto(CategoriesDto categoriesDto);
}
