package com.example.api.controller;


import com.example.api.model.Person;
import com.example.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private PersonRepository personRepository;
    //getALL
    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personRepository.getAll();
    }

    //Count số người của từng nước
    @GetMapping("/cau1")
    public Map<String, Long> countPeople() {
        return personRepository.countPeople();
    }

    @GetMapping("/cau2")
    public List<Map.Entry<String,Long>> countPeople1(){
        return personRepository.countPeopleSortAZ();
    }

    @GetMapping("/avgAge")
    public List<Map.Entry<String, Double>> avg(){
        return  personRepository.avgAgeSort();
    }
    @GetMapping("/groupBy")
    public  Map<String, List<Person>> groupBy(){
        return personRepository.groupBy();
    }
    @GetMapping("filter")
    public List<Person> filter(){
        return  personRepository.filter();
    }

}
