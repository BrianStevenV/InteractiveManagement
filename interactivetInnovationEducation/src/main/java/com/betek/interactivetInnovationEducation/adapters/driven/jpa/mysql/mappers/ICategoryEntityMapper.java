package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {
    CategoryEntity toCategoryEntity(Category category);
    Category toCategory(CategoryEntity categoryEntity);

    CategoryResponseDto toCategoryResponseDto(CategoryEntity categoryEntity);
}
