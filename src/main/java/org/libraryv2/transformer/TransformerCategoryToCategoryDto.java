package org.libraryv2.transformer;

import org.libraryv2.dto.CategoryDto;
import org.libraryv2.model.Category;
import org.springframework.stereotype.Component;

@Component
public class TransformerCategoryToCategoryDto {
    public  CategoryDto transform(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
