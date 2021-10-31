package com.example.uploadfile.service;

import java.io.IOException;
import java.util.List;

import com.example.uploadfile.model.FileEntity;
import com.example.uploadfile.model.FileResponse;
import com.example.uploadfile.repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImple implements FileService{

    @Autowired
    private FileRepository fileRepository;

    @Override
    public FileEntity storeFile(MultipartFile file , String description) throws IOException {
        FileEntity fileEntity = new FileEntity();
        byte[] photo = file.getBytes();
        fileEntity.setContent(photo);
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setType(file.getContentType());
        fileEntity.setDescription(description);
        fileRepository.save(fileEntity);
        return fileEntity;
    }

    @Override
    public FileEntity getFile(Long id) {
        FileEntity file =  fileRepository.getById(id);
        return file;
    }

    @Override
    public List<FileResponse> getAllFile() {
        // TODO Auto-generated method stub
        return fileRepository.findAll();
    }
    
}
