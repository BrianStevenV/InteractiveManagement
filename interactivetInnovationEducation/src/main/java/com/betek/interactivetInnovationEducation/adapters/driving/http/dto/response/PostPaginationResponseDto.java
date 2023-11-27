package com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class PostPaginationResponseDto {
    private Long id;
    private ArrayList<String> media;
    private String caption;
    private String description;
    private ArrayList<Long> likes;
    private ArrayList<Long> comments;
    private Long topic;
    private LocalDate created_at;
    private Long idUser;
}
