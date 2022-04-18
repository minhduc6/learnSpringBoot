package com.example.sanphamapi.controller;

import com.example.sanphamapi.model.SanPham;
import com.example.sanphamapi.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("/listSanPham")
    public ResponseEntity<?> getListSP(){
        return  ResponseEntity.ok(sanPhamRepository.findAll());
    }

    @GetMapping("/sanpham/{id}")
    public  ResponseEntity<?> getKhachHangbyId(@PathVariable("id") int id) throws Exception {
        SanPham khachHang = sanPhamRepository.findById(id).orElseThrow(() -> new Exception("SanPham not found - " + id));
        return  ResponseEntity.ok(khachHang);
    }

    @PostMapping("/addSanPham")
    public  ResponseEntity<?> addSanPham(@RequestParam int id,@RequestParam String name ,@RequestParam String mota,@RequestParam Double giaNhap,
                                            @RequestParam Double giaBan , @RequestParam int soLuong){
        List<SanPham> listSanPham = sanPhamRepository.findAll();
        SanPham sp =
                new SanPham(id,name,mota,giaNhap,giaBan,soLuong);
        sanPhamRepository.save(sp);
        return ResponseEntity.ok(sp);
    }

    @PutMapping("/updateSanPham")
    public ResponseEntity<?> updateSanPham(@RequestParam int id,@RequestParam String name ,@RequestParam String mota,@RequestParam Double giaNhap,
                                             @RequestParam Double giaBan , @RequestParam int soLuong) throws Exception {
        SanPham sp
                = sanPhamRepository.findById(id).orElseThrow(() -> new Exception("SanPham not found - " + id));
        sp.setTenSP(name);
        sp.setMoTa(mota);
        sp.setGiaNhap(giaNhap);
        sp.setGiaBan(giaBan);
        sp.setSoLuong(soLuong);
        sanPhamRepository.save(sp);
        return ResponseEntity.ok(sp);
    }

    @DeleteMapping("/deleteSanPham")
    public ResponseEntity<?> deleteSanPham(@RequestParam int id){
        sanPhamRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }

    @GetMapping("/findByKeyword")
    public ResponseEntity<?> findByKeyWord(@RequestParam String keyword){
        List<SanPham> result = new ArrayList<>();
        List<SanPham> listAll = sanPhamRepository.findAll();
        for (int i = 0; i < listAll.size(); i++) {
            if(listAll.get(i).findByKeyWord(keyword) == true){
                result.add(listAll.get(i));
            }
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/tonHang")
    public ResponseEntity<?> tonHang(){
        List<SanPham> result = new ArrayList<>();
        List<SanPham> listAll = sanPhamRepository.findAll();
        for (int i = 0; i < listAll.size(); i++) {
            if(listAll.get(i).getSoLuong() > 0){
                result.add(listAll.get(i));
            }
        }
        return ResponseEntity.ok(result);
    }
}
