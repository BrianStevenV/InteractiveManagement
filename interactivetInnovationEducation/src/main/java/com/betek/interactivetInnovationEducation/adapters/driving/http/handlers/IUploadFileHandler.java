package com.betek.interactivetInnovationEducation.adapters.driving.http.handlers;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileHandler {
    String handleFileUpload(MultipartFile file);
}
