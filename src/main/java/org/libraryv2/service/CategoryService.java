package org.libraryv2.service;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.CategoryDto;
import org.libraryv2.model.Category;
import org.libraryv2.repository.CategoryRepository;
import org.libraryv2.transformer.TransformerCategoryToCategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final TransformerCategoryToCategoryDto transformerCategoryToCategoryDto;


    public void save(Category category) {
        categoryRepository.save(category);
    }
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll().stream().map(transformerCategoryToCategoryDto::transform).toList();
    }

    public Category findById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

}
