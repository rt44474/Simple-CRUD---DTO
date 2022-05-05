package com.example.simplecruddto.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPersonDto {
    private Long id;
    private String firstName;
    private String lastName;
}
