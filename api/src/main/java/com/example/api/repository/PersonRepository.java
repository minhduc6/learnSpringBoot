package com.example.api.repository;

import com.example.api.model.Person;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    private final ArrayList<Person> people;

    public PersonRepository() {
        people = new ArrayList<>(List.of(new Person("Vinh", "Vietnam", 28), new Person("Lan", "Vietnam", 24), new Person("John", "USA", 27), new Person("Lee", "China", 67), new Person("Kim", "Korea", 22), new Person("Long", "Vietnam", 18), new Person("Jungho", "Korea", 19), new Person("Tian", "China", 20), new Person("Clara", "USA", 40), new Person("Mikura", "Japan", 27), new Person("Sony", "Japan", 29), new Person("Xiang", "China", 78), new Person("Peter", "France", 18), new Person("Haloy", "Malaysia", 20), new Person("Magie", "Malaysia", 32)));
    }

    public List<Person> getAll() {
        return people;
    }

    // count people của từng nước
    public Map<String, Long> countPeople() {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()));
    }

    // count people của tưng nước sắp xếp tăng dần
    public List<Map.Entry<String, Long>> countPeopleSortASC() {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toList());
    }

    // count people của từng nước giảm dần

    public List<Map.Entry<String, Long>> countPeopleSortDES() {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
    }

    //Sapxep A-Z
    public List<Map.Entry<String, Long>> countPeopleSortAZ() {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).collect(Collectors.toList());
    }

    //Map
    public Map<String, Integer> countPeopleByMap() {
        Map<String, Integer> result = new HashMap<>();
        for (Person p : people) {
            if (result.get(p.getNationality()) == null) {
                result.put(p.getNationality(), 1);
            } else {
                result.put(p.getNationality(), result.get(p.getNationality()) + 1);
            }
        }
        return result;
    }

    // tính trung bình của mỗi đất nước
    public Map<String, Double> avgAge() {
        return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.averagingDouble(Person::getAge)));
    }

    public List<Map.Entry<String, Double>> avgAgeSort() {
        return  people.stream()
                .collect(Collectors.groupingBy(Person::getNationality,Collectors.averagingDouble(Person::getAge)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
    //group by
    public  Map<String, List<Person>>  groupBy(){
         Map<String,List<Person>> result = people.stream().collect(Collectors.groupingBy(Person::getNationality));
         return  result;
    }

    public List<Person> filter(){
        return people.stream().filter(person -> person.getAge() > 20)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
    }
}
