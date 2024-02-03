package com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.impl;

import com.betek.interactivetInnovationEducation.adapters.driving.http.handlers.IUploadFileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadFilesHandlerImp  implements IUploadFileHandler {

    @Override
    public String handleFileUpload(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if(fileSize > maxFileSize) {
                return "The File size exceed."; // Avoid NullPointerException
            }

            if(!fileOriginalName.endsWith(".jpg") && !fileOriginalName.endsWith(".png") && !fileOriginalName.endsWith(".pdf")){
                return "Only JPG, PNG or PDF";
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;


            //Create assets

            File folder = new File("src/main/resources/assets/");
            if(!folder.exists()){
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/assets/" + newFileName);
            Files.write(path, bytes);
            return "Files upload succesfully";

        }   catch (Exception e) {

            return null;

        }

    }
}
