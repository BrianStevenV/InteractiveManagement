package com.betek.interactivetInnovationEducation.adapters.driving.http.controller;

import com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.IUploadFileHandler;
import com.betek.interactivetInnovationEducation.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class UploadFilesController {

    @Autowired
    IUploadFileHandler uploadFileService;

    @Operation(summary = "Create a File",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Create File successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Creation fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/picture")
    private ResponseEntity<Map<String,String>> uploadPicture(@RequestPart("file") MultipartFile file){
        uploadFileService.handleFileUpload(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, "Correctly"));
    }

}
