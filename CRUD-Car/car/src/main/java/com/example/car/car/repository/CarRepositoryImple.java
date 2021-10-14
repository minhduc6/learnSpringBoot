package com.example.car.car.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.example.car.car.exception.NotFoundException;
import com.example.car.car.model.Car;

@Repository
public class CarRepositoryImple implements CarRepository {
       private static ArrayList<Car> cars = new ArrayList<>();

       public CarRepositoryImple() {

       try {
       File file = ResourceUtils.getFile("classpath:static/car.json");
       ObjectMapper mapper = new ObjectMapper();
       cars.addAll(mapper.readValue(file, new TypeReference<List<Car>>(){}));
       cars.forEach(System.out::println);
       } catch (Exception e) {
        System.out.println(e.getMessage());	
       }    

       }

       @Override
       public List<Car> getAll() {
             
              return cars;
       }

       @Override
       public Car getById(int id) {
              for (int i = 0; i < cars.size(); i++) {
                     if(cars.get(i).getId() == id)
                     {
                            return cars.get(i);
                     }
              }
              throw new NotFoundException("NOT FOUND CAR");
       }

       @Override
       public void addCar(Car car) {
              Car newCar = new Car();
              newCar.setId(cars.size() + 1);
              newCar.setPhoto(car.getPhoto());
              newCar.setModel(car.getModel());
              newCar.setManufacturer(car.getManufacturer());
              newCar.setPrice(car.getPrice());
              newCar.setSales(car.getSales());
              cars.add(newCar);
       }

       @Override
       public Car updateById(Car car, int id) {
             for (int i = 0; i < cars.size(); i++) {
                    if(cars.get(i).getId() == id)
                    {
                            cars.get(i).setPhoto(car.getPhoto());
                            cars.get(i).setModel(car.getModel());
                            cars.get(i).setManufacturer(car.getManufacturer());
                            cars.get(i).setPrice(car.getPrice());
                            cars.get(i).setSales(car.getSales());
                            return cars.get(i);
                    }
             }
             throw new NotFoundException("NOT FOUND CAR");
       }

       @Override
       public void deleteById(int id) {
           for (int i = 0; i < cars.size(); i++) {
                  if(cars.get(i).getId() == id)
                  {
                         cars.remove(i);
                  }
           }
       }

       @Override
       public List<Car> searchByKeyWord(String keyword) {
              List<Car> listSearch = new ArrayList<>();
              for (int i = 0; i < cars.size(); i++) {
                     if(cars.get(i).getModel().toLowerCase().indexOf(keyword) != -1 || cars.get(i).getManufacturer().toLowerCase().indexOf(keyword) != -1 )
                     {
                            listSearch.add(cars.get(i));
                     }
              }
              return listSearch;
       }

       @Override
       public void sortPrice() {
              Collections.sort(cars, (a, b) -> a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1);
       }

       @Override
       public void sortName() {
              Collections.sort(cars, (a, b) -> a.getModel().compareToIgnoreCase(b.getModel()));
       }
       

       
      
}
