package com.betek.interactivetInnovationEducation.domain.spi;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import org.springframework.data.domain.Page;

public interface ICategoryPersistencePort {
    void createCategory(Category category);
    Page<CategoryResponseDto> getCategoryAll();
    void deleteCategory(Long idCategory);
}
