package com.example.uploadfile.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.uploadfile.model.FileResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @GetMapping("/files")
    public ResponseEntity<List<FileResponse>> getFiles()
    {
        List<FileResponse> files = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id)
    {

    }
}
