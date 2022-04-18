package com.example.jsapi.controller;

import com.example.jsapi.Request.BmiRequest;
import com.example.jsapi.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BmiController {
    @Autowired
    private BmiService bmiService;
    @GetMapping("/bmi")
    public ResponseEntity<?> calculateBmiGet(@RequestParam double weight , @RequestParam double height){
          double bmi = bmiService.caculateBmi(height,weight);
          return  ResponseEntity.ok(bmi);
    }
    @PostMapping("/bmi")
    public ResponseEntity<?> calculateBmiPost(@RequestBody BmiRequest bmiRequest){
        double bmi = bmiService.caculateBmi(bmiRequest.getHeight(),bmiRequest.getWeight());
        return  ResponseEntity.ok(bmi);
    }
}
