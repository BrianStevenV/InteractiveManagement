package com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.impl;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.PostRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.request.CategoryCreateRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.IManagementHandler;
import com.betek.interactivetInnovationEducation.adapters.driving.http.mappers.ICategoryRequestMapper;
import com.betek.interactivetInnovationEducation.adapters.driving.http.mappers.IPostRequestMapper;
import com.betek.interactivetInnovationEducation.domain.api.ICategoryServicePort;
import com.betek.interactivetInnovationEducation.domain.api.IManagementServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagementHandlerImpl implements IManagementHandler {
    private final IManagementServicePort managementServicePort;
    private final ICategoryServicePort categoryServicePort;

    private final IPostRequestMapper postRequestMapper;
    private final ICategoryRequestMapper categoryRequestMapper;
    @Override
    public void createPost(PostRequestDto postRequestDto) {
        managementServicePort.createPost(postRequestMapper.toPost(postRequestDto));
    }

    @Override
    public void deletePost(Long idPost) {
        managementServicePort.deletePost(idPost);
    }

    @Override
    public Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory) {
        return managementServicePort.getHomeFromPagination(idCountry, idCategory);
    }

    @Override
    public Page<PostPaginationResponseDto> getPostFromProfile() {
        return managementServicePort.getPostFromProfile();
    }

    @Override
    public void createCategory(CategoryCreateRequestDto categoryCreateRequestDto) {
        categoryServicePort.createCategory(categoryRequestMapper.toCategory(categoryCreateRequestDto));
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryServicePort.deleteCategory(idCategory);
    }

    @Override
    public Page<CategoryResponseDto> getCategoryAll() {
        return categoryServicePort.getCategoryAll();
    }
}
