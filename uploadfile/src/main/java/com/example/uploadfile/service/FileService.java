package com.example.uploadfile.service;

import java.io.IOException;
import java.util.List;


import com.example.uploadfile.model.FileEntity;
import com.example.uploadfile.model.FileResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity storeFile(MultipartFile file , String description) throws IOException;
    FileEntity getFile(Long id);
    List<FileResponse> getAllFile();
}
 