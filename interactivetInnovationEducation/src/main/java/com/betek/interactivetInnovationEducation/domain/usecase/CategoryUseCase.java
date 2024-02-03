package com.betek.interactivetInnovationEducation.domain.usecase;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.domain.api.ICategoryServicePort;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import com.betek.interactivetInnovationEducation.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;
    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        categoryPersistencePort.createCategory(category);
    }

    @Override
    public Page<CategoryResponseDto> getCategoryAll() {
        return categoryPersistencePort.getCategoryAll();
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryPersistencePort.deleteCategory(idCategory);
    }
}
