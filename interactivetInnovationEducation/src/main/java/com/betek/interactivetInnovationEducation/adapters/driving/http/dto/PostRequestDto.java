package com.betek.interactivetInnovationEducation.adapters.driving.http.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Getter
public class PostRequestDto {
    @NotBlank // Will be error ?
    private ArrayList<String> media;
    @NotBlank
    private String caption;
    @NotBlank
    private String description;
    @NotNull
    private Long topic;
    private LocalDate created_at;
}
