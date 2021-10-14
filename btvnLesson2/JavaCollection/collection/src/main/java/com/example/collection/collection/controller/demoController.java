package com.example.collection.collection.controller;

import java.util.List;
import java.util.Map;

import com.example.collection.collection.model.Person;
import com.example.collection.collection.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class demoController {

   @Autowired
   private PersonService personService;

   @GetMapping("/listPerson")
   public ResponseEntity<?> getListPer()
   {
          List<Person> people = personService.getList();
          return ResponseEntity.ok(people);
   }

    @GetMapping("/listPerson20to30")
   public ResponseEntity<?> getAge20to30()
   {
          List<Person> people = personService.age20to30();
          return ResponseEntity.ok(people);
   }

   @GetMapping("/ageTB")
   public ResponseEntity<?> ageTB()
   {
          Double age = personService.ageTB();
          return ResponseEntity.ok(age);
   }

   @GetMapping("/ageNationalAvg")
   public ResponseEntity<?> ageNationalAvg()
   {
          Map<String, Double> result = personService.ageByNationality();
          return ResponseEntity.ok(result);
   }
}
