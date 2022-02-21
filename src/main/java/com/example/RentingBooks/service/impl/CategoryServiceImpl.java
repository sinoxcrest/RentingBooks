package com.example.RentingBooks.service.impl;

import com.example.RentingBooks.dto.CategoryDto;
import com.example.RentingBooks.entity.Category;
import com.example.RentingBooks.repo.CategoryRepo;
import com.example.RentingBooks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category entity=Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
        entity=categoryRepo.save(entity);
        return categoryDto.builder().
                id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();

    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(entity ->CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build()).collect(Collectors.toList());
    }
    @Override
    public CategoryDto findById(Integer id) {
        return null;
    }
}
