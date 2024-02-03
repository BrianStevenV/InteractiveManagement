package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.adapter;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.PostEntity;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers.IPostEntityMapper;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories.IPostRepository;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import com.betek.interactivetInnovationEducation.domain.spi.IManagementPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class PostMysqlAdapter implements IManagementPersistencePort {
    private final IPostRepository managementRepository;
    private final IPostEntityMapper postEntityMapper;
    @Override
    public void createPost(Post post) {
        managementRepository.save(postEntityMapper.toPostEntity(post));
    }

    @Override
    public void deletePost(Long idPost, Long idUser) {
        managementRepository.deleteById(idPost);
    }

//    @Override
//    public Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory) { // GET QUE ALIMENTA EL FRONTEND.
//        Pageable pageable = PageRequest.of(0,10);
//        Page<PostEntity> postEntityPage = managementRepository.findByIdCountryAndIdCategory(idCountry, idCategory, pageable);
//        return postEntityPage.map(postEntityMapper::toPostPaginationResponseDto);
//    }

    @Override
    public Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory) {
        Pageable pageable = PageRequest.of(0, 10);
        return managementRepository.findByIdCountryAndIdCategory(idCountry, idCategory, pageable)
                .map(postEntityMapper::toPostPaginationResponseDto);
    }


    @Override
    public Page<PostPaginationResponseDto> getPostFromProfile(Long idUser) { // EL USUARIO CUANDO MIRA SU CUENTA PUEDE VER SUS PROPIAS PUBLICACIONES, TODAS LAS QUE TIENE REGISTRADAS A SU
                                                                            // CUENTA.
        Integer count = managementRepository.countPostsByUserId(idUser);
        Pageable pageable = PageRequest.of(0, count);
        Page<PostEntity> postEntityPage = managementRepository.findPostsByUserId(idUser, pageable);
        return postEntityPage.map(postEntityMapper::toPostPaginationResponseDto);
    }

    @Override
    public Page<PostPaginationResponseDto> getHomeFromPaginationByCategory(Long idCategory) {
        Pageable pageable = PageRequest.of(0,10);
        Page<PostEntity> postEntityPage = managementRepository.findByIdCategory(idCategory, pageable);
        return postEntityPage.map(postEntityMapper::toPostPaginationResponseDto);
    }

    @Override
    public Page<PostPaginationResponseDto> getHomeFromPaginationByCountry(Long idCountry) {
        Pageable pageable = PageRequest.of(0,10);
        Page<PostEntity> postEntityPage = managementRepository.findByIdCountry(idCountry, pageable);
        return postEntityPage.map(postEntityMapper::toPostPaginationResponseDto);
    }

    @Override
    public Post findByIdAndIdUser(Long idPost, Long idUser) {
        PostEntity postEntity = managementRepository.findByIdAndIdUser(idPost, idUser);
        return postEntityMapper.toPost(postEntity);
    }
}
