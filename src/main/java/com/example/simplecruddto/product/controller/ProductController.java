package com.example.simplecruddto.product.controller;

import com.example.simplecruddto.person.dto.PersonDto;
import com.example.simplecruddto.product.dto.ProductDto;
import com.example.simplecruddto.product.entity.Product;
import com.example.simplecruddto.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/product"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(productService
        .getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(productService
        .getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto ){
        return ResponseEntity.ok(productService
        .save(productDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto, @PathVariable Long id){
        productDto.setId(id);
        return ResponseEntity.ok(productService
        .update(productDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("OK");
    }
}
