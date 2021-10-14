package com.example.car.car.controller;

import java.util.List;

import com.example.car.car.model.Car;
import com.example.car.car.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarControler {
       @Autowired
       private CarRepository carRepository;
       
       @GetMapping("/cars")
       public String getAll(Model model)
       {
              List<Car> cars = carRepository.getAll();
              model.addAttribute("cars", cars);
              return "home";
       }


  @GetMapping("car/new")
  public String addBook(Model model)
  {
         Car car = new Car();
         model.addAttribute("car", car);
         model.addAttribute("pageTitle", "Create New Book");
         return "car-form";
  }
  
  @PostMapping("car/save")
  public String saveBook(Car car)
  {
         int id = car.getId();
    if (id == 0) {
      carRepository.addCar(car);
    }
    else if(id != 0)
    {
           carRepository.updateById(car, id);
    }
    return "redirect:/cars";
  }

  @GetMapping("/car/edit/{id}")
  public String editCar(@PathVariable(name = "id") Integer id , Model model)
  {
         Car car = carRepository.getById(id);
         model.addAttribute("car", car);
         model.addAttribute("pageTitle", "Edit Car ID : " + id);
         return "car-form";
  }
  @GetMapping("/car/delete/{id}")
  public String deleteCar(@PathVariable(name = "id") Integer id , Model model)
  {
         carRepository.deleteById(id);
         return "redirect:/cars";
  }
  
  @GetMapping("/car/search")
  public String searchCar(@RequestParam(value = "keyword") String keyword , Model model)
  {
         List<Car> listSearch = carRepository.searchByKeyWord(keyword);
         model.addAttribute("cars", listSearch);
         return "home";
  }

  @GetMapping("/car/sapxep")
  public String sapXepCar(@RequestParam(value = "sapxep") int sapxep,  Model model)
  {
        
         if (sapxep == 1) {
                carRepository.sortPrice();
         }
         else if (sapxep == 2)
         {
                carRepository.sortName();

         }
         List<Car> cars = carRepository.getAll();
         model.addAttribute("cars", cars);
         return "home";
  }
       

}
