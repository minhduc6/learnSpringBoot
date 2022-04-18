package com.example.sinhvienapi.repository;

import com.example.sinhvienapi.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhvienRepository extends JpaRepository<SinhVien,Integer> {
    // Sử dụng JPA để thao tác với CSDL
}
