package com.betek.interactivetInnovationEducation.configuration;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.adapter.CategoryMysqlAdapter;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers.IPostEntityMapper;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories.IPostRepository;
import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.adapter.PostMysqlAdapter;
import com.betek.interactivetInnovationEducation.domain.api.ICategoryServicePort;
import com.betek.interactivetInnovationEducation.domain.spi.ICategoryPersistencePort;
import com.betek.interactivetInnovationEducation.domain.usecase.CategoryUseCase;
import com.betek.interactivetInnovationEducation.domain.usecase.ManagamentUseCase;
import com.betek.interactivetInnovationEducation.domain.api.IAuthenticationUserInfoServicePort;
import com.betek.interactivetInnovationEducation.domain.api.IManagementServicePort;
import com.betek.interactivetInnovationEducation.domain.spi.IManagementPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPostRepository managementRepository;
    private final IPostEntityMapper postEntityMapper;
    private final IAuthenticationUserInfoServicePort authenticationUserInfoServicePort;

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public IManagementServicePort managementServicePort(){
        return new ManagamentUseCase(managementPersistencePort(), authenticationUserInfoServicePort);
    }
    @Bean
    public IManagementPersistencePort managementPersistencePort(){
        return new PostMysqlAdapter(managementRepository, postEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }
    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryMysqlAdapter(categoryRepository, categoryEntityMapper);
    }

}
