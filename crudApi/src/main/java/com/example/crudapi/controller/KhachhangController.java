package com.example.crudapi.controller;

import com.example.crudapi.enitity.KhachHang;
import com.example.crudapi.repository.KhachhangRepository;
import com.example.crudapi.request.KhachhangRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class KhachhangController {
    @Autowired
    private KhachhangRepository khachhangRepository;
    @GetMapping("/listKhachHang")
    public ResponseEntity<?> getListKhachHang(){
        return  ResponseEntity.ok(khachhangRepository.findAll());
    }
    @GetMapping("/khachhang/{id}")
    public  ResponseEntity<?> getKhachHangbyId(@PathVariable("id") int id) throws Exception {
        KhachHang khachHang = khachhangRepository.findById(id).orElseThrow(() -> new Exception("KhachHang not found - " + id));
        return  ResponseEntity.ok(khachHang);
    }
    @PostMapping("/addKhachhang")
    public  ResponseEntity<?> addKhachHang(@RequestBody KhachhangRequest khachhangRequest){
        List<KhachHang> listKhachHang = khachhangRepository.findAll();
        KhachHang khachHang = new KhachHang(listKhachHang.size()+1,khachhangRequest.getName(),khachhangRequest.getAddress(),khachhangRequest.getPhoneNumber());
        khachhangRepository.save(khachHang);
        return ResponseEntity.ok(khachHang);
    }
    @PostMapping("/add1Khachhang")
    public  ResponseEntity<?> add1KhachHang(@RequestParam int id,@RequestParam String name ,@RequestParam String address,@RequestParam String phoneNumber){
        List<KhachHang> listKhachHang = khachhangRepository.findAll();
        KhachHang khachHang =
                new KhachHang(id,name,address,phoneNumber);
        khachhangRepository.save(khachHang);
        return ResponseEntity.ok(khachHang);
    }
    @PutMapping("/updateKhachhang")
    public ResponseEntity<?> updateKhachHang(@RequestParam int id,@RequestParam String name ,@RequestParam String address,@RequestParam String phoneNumber) throws Exception {
        KhachHang khachHang
                = khachhangRepository.findById(id).orElseThrow(() -> new Exception("KhachHang not found - " + id));
        khachHang.setName(name);
        khachHang.setAddress(address);
        khachHang.setPhoneNumber(phoneNumber);
        khachhangRepository.save(khachHang);
        return ResponseEntity.ok(khachHang);
    }

    @DeleteMapping("/deleteKhachhang")
    public ResponseEntity<?> deleteKhachhang(@RequestParam int id){
        khachhangRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }
}
