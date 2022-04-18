package com.example.dataanalysis.controller;

import com.example.dataanalysis.model.Person;
import com.example.dataanalysis.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<Person> result = personRepo.getAll();
        return  ResponseEntity.ok(result);
    }
    @GetMapping("/cau1")
    public ResponseEntity<?> groupByCity(){
        Map<String,List<Person>> result = personRepo.groupByCity();
        return  ResponseEntity.ok(result);
    }
    @GetMapping("/cau2")
    public ResponseEntity<?> groupPeopleByJob(){
        Map<String,Long> result  = personRepo.GroupByJob();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cau3")
    public ResponseEntity<?> top5JobNum(){
        List<Map.Entry<String,Long>> result  = personRepo.top5JobsNumber();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cau4")
    public ResponseEntity<?> top5CitiesByNumber(){
        List<Map.Entry<String,Long>> result  = personRepo.top5CitiesByNumber();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cau5")
    public ResponseEntity<?> topJobByNumerInEachCity(){
        Map<String, Map.Entry<String, Long>> result  = personRepo.topJobByNumerInEachCity();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cau6")
    public ResponseEntity<?> avgSalaryJob(){
        Map<String,Double> result = personRepo.averageSalaryByJob();
        return  ResponseEntity.ok(result);
    }
    @GetMapping("/cau7")
    public ResponseEntity<?> maxDeveloperJob(){
        List<Map.Entry<String,Double>> result = personRepo.avaerageDevelopSalaryByCity();
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/cau8")
    public ResponseEntity<?> avgAgeJob(){
        Map<String,Double> result = personRepo.avgAgeJob();
        return  ResponseEntity.ok(result);
    }


    @GetMapping("/cau9")
    public ResponseEntity<?> avgAgeCity(){
        Map<String,Double> result = personRepo.avgAgeCity();
        return  ResponseEntity.ok(result);
    }
}
