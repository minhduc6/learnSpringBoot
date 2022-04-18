package com.example.jsapi.controller;

import com.example.jsapi.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    private ColorService colorService;
    @GetMapping("random-color")
    public ResponseEntity<?> randomColor(@RequestParam int type){
       return  ResponseEntity.ok(colorService.randomColor(type));
    }
}
