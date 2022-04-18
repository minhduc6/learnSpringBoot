package com.example.crudapi.repository;

import com.example.crudapi.enitity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachhangRepository extends JpaRepository<KhachHang,Integer> {

}
