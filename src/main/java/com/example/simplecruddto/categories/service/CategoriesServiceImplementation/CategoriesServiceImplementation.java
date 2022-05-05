package com.example.simplecruddto.categories.service.CategoriesServiceImplementation;

import com.example.simplecruddto.categories.dto.CategoriesDto;
import com.example.simplecruddto.categories.entity.Categories;
import com.example.simplecruddto.categories.mappers.CategoriesMappers;
import com.example.simplecruddto.categories.repository.CategoriesRepository;
import com.example.simplecruddto.categories.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesServiceImplementation implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    protected CategoriesMappers categoriesMappers;


    @Override
    public List<CategoriesDto> getAll() {
        return categoriesRepository.findAll()
                .stream()
                .map(this.categoriesMappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriesDto getById(Long id) {
        Optional<Categories> categoriesOptional = this.categoriesRepository.findById(id);
        return this.categoriesMappers.toDto(
                categoriesOptional.get()
        );
    }

    @Override
    public CategoriesDto update(CategoriesDto categoriesDto) {
        Optional<Categories> currentCategoriesOptional = this.categoriesRepository.findById(categoriesDto.getId());

        Categories currentCategories = currentCategoriesOptional.get();

        currentCategories.setName(categoriesDto.getName());
        currentCategories.setProduct_id(categoriesDto.getProduct_id());
        return this.categoriesMappers.toDto(
                this.categoriesRepository.save(currentCategories)
        );
    }

    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {
        Categories newCategories = this.categoriesMappers.fromDto(categoriesDto);
        return this.categoriesMappers.toDto(
                this.categoriesRepository.save(newCategories)
        );
    }

    @Override
    public void delete(Long id) {
        this.categoriesRepository.deleteById(id);

    }
}
