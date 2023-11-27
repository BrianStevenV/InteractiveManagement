package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.mappers;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.PostEntity;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPostEntityMapper {
    PostEntity toPostEntity(Post post);
    PostPaginationResponseDto toPostPaginationResponseDto(PostEntity postEntity);

    Post toPost(PostEntity postEntity);
}
