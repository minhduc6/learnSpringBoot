package com.example.sinhvienapi.controller;


import com.example.sinhvienapi.entity.SinhVien;
import com.example.sinhvienapi.exception.BadRequestException;
import com.example.sinhvienapi.repository.SinhvienRepository;
import com.example.sinhvienapi.request.SinhvienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SinhvienController {
    @Autowired
    private SinhvienRepository sinhvienRepository;

    // Lấy toàn bộ sinh viên
    @GetMapping("/listSinhVien")
    public ResponseEntity<?> getListSinhVien(){
        return  ResponseEntity.ok(sinhvienRepository.findAll());
    }

    // Tìm kiếm sinh viên theo id
    @GetMapping("/sinhvien/{id}")
    public  ResponseEntity<?> getKhachHangbyId(@PathVariable("id") int id) throws Exception {
        // tìm kiếm sinh viên theo id nếu id không tồn tại thì throw ra lỗi
        SinhVien sv = sinhvienRepository.findById(id).orElseThrow(() -> new BadRequestException("Sinh Viên Không Tồn Tại"));
        return  ResponseEntity.ok(sv);
    }

    // Thêm Sinh Viên
    @PostMapping("/addSinhVien")
    public  ResponseEntity<?> addSinhVien(@RequestBody SinhvienRequest sinhvienRequest){
        List<SinhVien> listSinhVien = sinhvienRepository.findAll();
        SinhVien sv = new SinhVien(listSinhVien.size()+1, sinhvienRequest.getName(),sinhvienRequest.getAge(),sinhvienRequest.getCountry());
        sinhvienRepository.save(sv);
        return ResponseEntity.ok(sv);
    }
    // Sửa Sinh Viên
    @PutMapping("/updateSinhVien/{id}")
    public ResponseEntity<?> updateSanPham(@PathVariable("id") int id ,@RequestBody SinhvienRequest sinhvienRequest) throws Exception {
        SinhVien sv = sinhvienRepository.findById(id).orElseThrow(() -> new BadRequestException("Sinh Viên Không Tồn Tại"));
        sv.setName(sinhvienRequest.getName());
        sv.setAge(sinhvienRequest.getAge());
        sv.setCountry((sinhvienRequest.getCountry()));
        sinhvienRepository.save(sv);
        return ResponseEntity.ok(sv);
    }

    // Xoá Sinh Viên
    @DeleteMapping("/deleteSinhVien/{id}")
    public ResponseEntity<?> deleteSanPham(@PathVariable("id") int id){
        sinhvienRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }
}
