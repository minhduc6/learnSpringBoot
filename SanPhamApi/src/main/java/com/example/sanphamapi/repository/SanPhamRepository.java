package com.example.sanphamapi.repository;

import com.example.sanphamapi.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
}
