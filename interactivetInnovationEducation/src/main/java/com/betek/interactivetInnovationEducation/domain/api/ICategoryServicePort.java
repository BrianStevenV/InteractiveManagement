package com.betek.interactivetInnovationEducation.domain.api;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import org.springframework.data.domain.Page;

public interface ICategoryServicePort {
    void createCategory(Category category);
    Page<CategoryResponseDto> getCategoryAll();
    void deleteCategory(Long idCategory);
}
