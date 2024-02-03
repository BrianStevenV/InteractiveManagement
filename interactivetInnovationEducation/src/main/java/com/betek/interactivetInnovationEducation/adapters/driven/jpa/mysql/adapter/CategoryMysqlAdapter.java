package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.adapter;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import com.betek.interactivetInnovationEducation.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CategoryMysqlAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    @Override
    public void createCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }

    @Override
    public Page<CategoryResponseDto> getCategoryAll() {
        Pageable pageable = PageRequest.of(0, 1); // SE DEBE CAMBIAR
        Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pageable);
        return categoryEntityPage.map(categoryEntityMapper::toCategoryResponseDto);
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
