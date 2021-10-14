package com.example.car.car.controller;

import java.util.List;

import com.example.car.car.model.Car;
import com.example.car.car.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarRestController {
       @Autowired
       private CarRepository carRepository;
       @GetMapping("/cars")
       public ResponseEntity<?> getAll()
       {
              List<Car> cars = carRepository.getAll();
              return ResponseEntity.ok().body(cars);
       }
       
}
