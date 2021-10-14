package com.example.collection.collection.service;

import java.util.List;
import java.util.Map;

import com.example.collection.collection.model.Person;

import org.springframework.stereotype.Component;

@Component
public interface PersonService {

       public List<Person> getList();

       public List<Person> age20to30();
       
       public Double ageTB();

       public Map<String, Double> ageByNationality();
       
}
