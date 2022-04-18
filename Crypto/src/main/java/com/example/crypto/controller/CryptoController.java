package com.example.crypto.controller;

import com.example.crypto.model.Crypto;
import com.example.crypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;


    @GetMapping("/list")
    public List<Crypto> getCrypto() {
        return cryptoService.getCrypto();
    }
}
