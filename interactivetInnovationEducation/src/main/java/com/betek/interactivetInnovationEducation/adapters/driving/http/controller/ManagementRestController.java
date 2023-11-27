package com.betek.interactivetInnovationEducation.adapters.driving.http.controller;

import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.PostRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.request.CategoryCreateRequestDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.CategoryResponseDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.dto.response.PostPaginationResponseDto;
import com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.IManagementHandler;
import com.betek.interactivetInnovationEducation.configuration.Constants;
import com.betek.interactivetInnovationEducation.domain.api.IAuthenticationUserInfoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/management/")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class ManagementRestController {
    private final IManagementHandler managementHandler;
    @Operation(summary = "Create a post",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Create post successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Creation fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAuthority('MEMBER_ROLE')")
    @PostMapping("post/")
    public ResponseEntity<Map<String, String>> createPosts(@RequestBody PostRequestDto postRequestDto){ // Or @RequestParam;
        managementHandler.createPost(postRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.POSTS_CREATED_MESSAGE));
    }

    @Operation(summary = "Delete post",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete post successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete post fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAuthority('MEMBER_ROLE')")
    @DeleteMapping("post/") // USUARIO CUANDO CONSULTA SU PROPIO PERFIL Y TRAE SUS POTS CON EL GET, PUEDE ELIMINAR
    public ResponseEntity<Map<String, String>> deletePost(@RequestParam Long idPost){
        managementHandler.deletePost(idPost);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.POST_DELETED_MESSAGE));
    }
    @Operation(summary = "Create category",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Create category successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Creation category fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAuthority('ADMINISTRATOR_ROLE')")
    @PostMapping("category/")
    public ResponseEntity<Map<String,String>> createCategory(@Valid @RequestBody CategoryCreateRequestDto categoryCreateRequestDto){
        managementHandler.createCategory(categoryCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CATEGORY_CREATED_MESSAGE));
    }

    @Operation(summary = "Delete category",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete category successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete category fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAuthority('ADMINISTRATOR_ROLE')")
    @DeleteMapping("category/")
    public ResponseEntity<Map<String, String>> deleteCategory(){
        managementHandler.deleteCategory();
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CATEGORY_DELETED_MESSAGE));
    }
    @Operation(summary = "Get category",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete category successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete category fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAuthority('ADMINISTRATOR_ROLE')")
    @GetMapping("category/")
    public Page<CategoryResponseDto> getCategoryAll(){
        return managementHandler.getCategoryAll();
    }

    @Operation(summary = "Get information to home.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Get user paging data. Print to home.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Get page error.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PreAuthorize("hasAnyAuthority('MEMBER_ROLE', 'ADMINISTRATOR_ROLE'")
    @GetMapping("home/")
    public Page<PostPaginationResponseDto> getHomeFromPagination(@RequestParam Long idCountry, @RequestParam Long idCategory){
        return managementHandler.getHomeFromPagination(idCountry, idCategory);
    }
    @PreAuthorize("hasAuthority('MEMBER_ROLE')")
    @GetMapping("profile/posts") // Yo como usuario - puedo ver mis publicaciones, y puedo eliminarlas.
    public Page<PostPaginationResponseDto> getPostFromProfile(){
        return managementHandler.getPostFromProfile();
    }
}
