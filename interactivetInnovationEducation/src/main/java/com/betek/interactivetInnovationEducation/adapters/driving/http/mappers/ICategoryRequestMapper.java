package com.betek.interactivetInnovationEducation.adapters.driving.http.mappers;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.request.CategoryCreateRequestDto;
import com.betek.interactivetInnovationEducation.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {
    Category toCategory(CategoryCreateRequestDto categoryCreateRequestDto);
}
