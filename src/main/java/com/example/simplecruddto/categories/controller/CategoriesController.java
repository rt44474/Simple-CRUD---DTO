package com.example.simplecruddto.categories.controller;

import com.example.simplecruddto.categories.dto.CategoriesDto;
import com.example.simplecruddto.categories.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/categories"})
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> getAll() {
        return ResponseEntity.ok(categoriesService
                .getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriesDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriesService
                .getById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriesDto> save(@RequestBody CategoriesDto categoriesDto) {
        return ResponseEntity.ok(categoriesService
                .save(categoriesDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriesDto> update(@RequestBody CategoriesDto categoriesDto, @PathVariable Long id) {
        categoriesDto.setId(id);
        return ResponseEntity.ok(categoriesService
                .update(categoriesDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        categoriesService.delete(id);
        return ResponseEntity.ok("OK");
    }
}
