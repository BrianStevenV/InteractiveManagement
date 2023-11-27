package com.betek.interactivetInnovationEducation.domain.api;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import org.springframework.data.domain.Page;

public interface IManagementServicePort {
    void createPost(Post post);
    void deletePost(Long idPost);

    Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory);
    Page<PostPaginationResponseDto> getPostFromProfile();
}
