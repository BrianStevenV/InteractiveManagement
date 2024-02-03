package com.betek.interactivetInnovationEducation.domain.usecase;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.api.IAuthenticationUserInfoServicePort;
import com.betek.interactivetInnovationEducation.domain.api.IManagementServicePort;
import com.betek.interactivetInnovationEducation.domain.exceptions.BadPostDeleteIntentException;
import com.betek.interactivetInnovationEducation.domain.exceptions.HomeCategoriesFilterException;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import com.betek.interactivetInnovationEducation.domain.spi.IManagementPersistencePort;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ManagamentUseCase implements IManagementServicePort {

    private final IManagementPersistencePort managementPersistencePort;
    private final IAuthenticationUserInfoServicePort authenticationUserInfoServicePort;

    public ManagamentUseCase(IManagementPersistencePort managementPersistencePort, IAuthenticationUserInfoServicePort authenticationUserInfoServicePort) {
        this.managementPersistencePort = managementPersistencePort;
        this.authenticationUserInfoServicePort = authenticationUserInfoServicePort;
    }

    @Override
    public void createPost(Post post) {
        Long idUser = authenticationUserInfoServicePort.getIdUserFromToken();
        post.setIdUser(idUser);
        post.setCreated_at(LocalDate.now());
        managementPersistencePort.createPost(post);
    }

    @Override
    public void deletePost(Long idPost) {
        Long idUser = authenticationUserInfoServicePort.getIdUserFromToken();
        Post post = managementPersistencePort.findByIdAndIdUser(idPost, idUser);
        System.out.println(" ID USER FROM AUTHENTICATION SERVICE: " + idUser);
        if(idPost == post.getId() && idUser == post.getIdUser()){
            managementPersistencePort.deletePost(idPost, idUser);
        }   else{
            throw new BadPostDeleteIntentException();
        }


    }

    @Override
    public Page<PostPaginationResponseDto> getHomeFromPagination(Long idCountry, Long idCategory) {
        if(idCountry != null && idCategory != null){
            return managementPersistencePort.getHomeFromPagination(idCountry, idCategory);
        } else if (idCountry == null) {
            return managementPersistencePort.getHomeFromPaginationByCategory(idCategory);
        } else if (idCategory == null) {
            return managementPersistencePort.getHomeFromPaginationByCountry(idCountry);
        }   else{
            throw new HomeCategoriesFilterException();
        }

    }

    @Override
    public Page<PostPaginationResponseDto> getPostFromProfile() {
        Long idUser = authenticationUserInfoServicePort.getIdUserFromToken();
        return managementPersistencePort.getPostFromProfile(idUser);
    }
}
