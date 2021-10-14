package com.example.car.car.repository;


import java.util.List;

import com.example.car.car.model.Car;

import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository {
       public List<Car> getAll();

       public Car getById(int id);

       public void addCar(Car car);

       public Car updateById(Car car, int id);

       public void deleteById(int id);
       
       public List<Car> searchByKeyWord(String keyword);

       public void sortPrice();

       public void sortName();
}
