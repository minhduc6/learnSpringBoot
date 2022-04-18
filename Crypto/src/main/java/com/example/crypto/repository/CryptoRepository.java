package com.example.crypto.repository;

import com.example.crypto.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CryptoRepository extends JpaRepository<Crypto, String> {
}
