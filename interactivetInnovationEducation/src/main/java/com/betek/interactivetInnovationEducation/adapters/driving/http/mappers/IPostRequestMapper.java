package com.betek.interactivetInnovationEducation.adapters.driving.http.mappers;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.PostRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.domain.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPostRequestMapper {
    Post toPost(PostRequestDto postRequestDto);
//    Post toPostFromPageResponse(PostPaginationResponseDto postPaginationResponseDto);
    //TODO: THIS IS NECESSARY???
}
