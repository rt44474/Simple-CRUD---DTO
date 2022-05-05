package com.example.simplecruddto.categories.service;

import com.example.simplecruddto.categories.dto.CategoriesDto;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDto> getAll();
    CategoriesDto getById(Long id);
    CategoriesDto update(CategoriesDto categoriesDto);
    CategoriesDto save(CategoriesDto categoriesDto);
    void delete(Long id);
}
