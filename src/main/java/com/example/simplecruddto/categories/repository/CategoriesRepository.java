package com.example.simplecruddto.categories.repository;

import com.example.simplecruddto.categories.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
