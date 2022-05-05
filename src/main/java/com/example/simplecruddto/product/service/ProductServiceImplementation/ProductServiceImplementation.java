package com.example.simplecruddto.product.service.ProductServiceImplementation;

import com.example.simplecruddto.product.dto.ProductDto;
import com.example.simplecruddto.product.entity.Product;
import com.example.simplecruddto.product.mappers.ProductMappers;
import com.example.simplecruddto.product.repository.ProductRepository;
import com.example.simplecruddto.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    protected ProductMappers productMappers;


    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this.productMappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        return this.productMappers.toDto(
                productOptional.get()
        );
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Optional<Product> currentProductOptional = this.productRepository.findById(productDto.getId());

        Product currentProduct = currentProductOptional.get();

        currentProduct.setName(productDto.getName());
        currentProduct.setPerson_id(productDto.getPerson_id());
        return this.productMappers.toDto(
                this.productRepository.save(currentProduct)
        );
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product newProduct = this.productMappers.fromDto(productDto);
        return this.productMappers.toDto(
                this.productRepository.save(newProduct)
        );

    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);

    }
}
