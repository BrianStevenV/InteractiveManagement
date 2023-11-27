package com.betek.interactivetInnovationEducation.adapters.driving.http.handlers;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.PostRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.request.CategoryCreateRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import org.springframework.data.domain.Page;

public interface IManagementHandler {
    void createPost(PostRequestDto postRequestDto);
    void deletePost(Long idPost);

    Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory);
    Page<PostPaginationResponseDto> getPostFromProfile();


    void createCategory(CategoryCreateRequestDto categoryCreateRequestDto);
    void deleteCategory();

    Page<CategoryResponseDto> getCategoryAll();
}
