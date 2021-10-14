package com.example.collection.collection.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.collection.collection.model.Person;

import org.springframework.stereotype.Component;


@Component
public class PersonServiceIpm implements PersonService {
       private static ArrayList<Person> people = new ArrayList<Person>();
       
       static
       {
              people.add(new Person("A", "VietNam", 18));
              people.add(new Person("B", "Enngland", 20));
              people.add(new Person("C", "American", 25));
              people.add(new Person("D", "Mexico", 40));
              people.add(new Person("E", "VietNam", 24));
       }

       @Override
       public List<Person> getList() {
              // TODO Auto-generated method stub
              return people;
       }

       @Override
       public List<Person> age20to30() {

              return (List<Person>) people.stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 30).toList();
       }

       @Override
       public Double ageTB() {
              Double result = people
                    .stream()
                    .collect(Collectors.averagingInt(Person::getAge));
    
              return result;
       }

       @Override
       public Map<String, Double> ageByNationality() {
              // TODO Auto-generated method stub
               Map<String, Double> result = people.stream()
               .collect(Collectors.groupingBy(Person::getNationality,Collectors.averagingInt(Person::getAge)));
              return result;
       }
       
       


}
