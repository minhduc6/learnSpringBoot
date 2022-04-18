package com.example.crypto.service;

import com.example.crypto.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CryptoService {

    public List<Crypto> getCrypto();

}
