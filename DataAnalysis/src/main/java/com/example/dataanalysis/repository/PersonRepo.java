package com.example.dataanalysis.repository;

import com.example.dataanalysis.model.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonRepo {
    private final List<Person> people = new ArrayList<Person>();
    //Constructor đọc toàn bộ dữ liệu từ JSON vào
    public PersonRepo() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file;
        try {
            file = ResourceUtils.getFile("classpath:static/personsmall.json");
            people.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {
            }));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Get All
    public List<Person> getAll() {
        return people;
    }
    // Gom tat ca nhung nguoi cung thanh pho lai
    public Map<String,List<Person>> groupByCity(){
        return people.stream().collect(Collectors.groupingBy(Person::getCity));
    }

    // Nhóm các nghề nghiệp và đếm số người làm
    public Map<String, Long> GroupByJob(){
        return people.stream()
                .collect(Collectors.groupingBy(Person::getJob,Collectors.counting()));
    }

    // Tìm 5 nghề có nhiều người làm nhất, đếm từ cao xuống thấp
    public List<Map.Entry<String, Long>> top5JobsNumber(){
        return people.stream()
                .collect(Collectors.groupingBy(Person::getJob,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());
    }
    // Tìm 5 thành phố có nhiều người trong danh sách ở nhất, đếm từ cao xuống thấp
    public List<Map.Entry<String, Long>> top5CitiesByNumber(){
        return (List<Map.Entry<String, Long>>) people.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public Map.Entry<String, Long> topJobInPeopleGroup(List<Person> peopleGroup) {
        Optional<Map.Entry<String, Long>> result = peopleGroup
                .stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()))  //Nhóm theo Job
                .entrySet()
                .stream()
                .collect(Collectors.maxBy(Map.Entry.comparingByValue())); //Tìm lớn nhất

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Cannot find top job in people group");
        }
    }
    // Trong mỗi thành phố, hãy tìm ra nghề nào được làm nhiều nhất
    public Map<String, Map.Entry<String, Long>> topJobByNumerInEachCity(){
        Map<String, List<Person>> groupPeopleByCity = groupByCity();
        return groupPeopleByCity.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> topJobInPeopleGroup(entry.getValue())));
    }

    //Ứng với một nghề, hãy tính mức lương trung bình
    public Map<String,Double> averageSalaryByJob(){
        return people.stream()
                .collect(Collectors.groupingBy(Person::getJob,Collectors.averagingDouble(Person::getSalary)));
    }
    //Năm thành phố có mức lương trung bình cao nhất
    public Map<String,Double> avaerageSalaryByCity(){
        return (Map<String, Double>) people.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.averagingDouble(Person::getSalary)))
                .entrySet()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }
    // Năm thành phố có mức lương trung bình của developer cao nhất
    public List<Map.Entry<String,Double>> avaerageDevelopSalaryByCity(){
        List<Person> temp =  people.stream()
                .filter(p->"developer".equals(p.getJob()))
                .collect(Collectors.toList());
        return  temp.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.averagingDouble(Person::getSalary)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
    // Tuổi trung bình từng nghề nghiệp
    public Map<String, Double> avgAgeJob()
    {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getJob,Collectors.averagingInt(Person::getAge)));
    }
    //Tuổi trung bình ở từng thành phố
    public Map<String, Double> avgAgeCity()
    {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.averagingInt(Person::getAge)));
    }

}

