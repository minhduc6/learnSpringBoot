package com.example.jsapi.service;

import com.example.jsapi.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public double caculateBmi(double height , double weight){
        if(height <= 0 || weight <= 0){
            throw  new BadRequestException("Dữ liệu không hợp lệ");
        }
        return weight / (height * height);
    }
}
