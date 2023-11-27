package com.betek.interactivetInnovationEducation.domain.spi;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import org.springframework.data.domain.Page;

public interface IManagementPersistencePort {
    void createPost(Post post);
    void deletePost(Long idPost, Long idUser);
    Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory); // put @!param
    Page<PostPaginationResponseDto> getPostFromProfile(Long idUser);


    Page<PostPaginationResponseDto> getHomeFromPaginationByCategory(Long idCategory);
    Page<PostPaginationResponseDto> getHomeFromPaginationByCountry(Long idCountry);

    Post findByIdAndIdUser(Long idPost, Long idUser);
}
